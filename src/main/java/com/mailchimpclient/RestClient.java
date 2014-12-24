package com.mailchimpclient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.mailchimpclient.exception.HttpError;
import com.mailchimpclient.exception.RestAPIException;
import com.mailchimpclient.response.RestAPIError;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.glassfish.jersey.client.ClientConfig;

public class RestClient {
	
	private final Client client;

	public RestClient(Client client) {
		this.client = client;
	}

	public RestClient() {
		this(ClientBuilder.newClient(getClientConfig()));
	}
	
	public Response post(String url, RestRequest<?> input) {
		Response response = client.target(url).path(input.getPath())
				 .request()
				 .post(Entity.entity(input.getBody(), MediaType.APPLICATION_JSON));

		if (response.getStatus() == Status.INTERNAL_SERVER_ERROR.getStatusCode()) {
			RestAPIError mappedError = response.readEntity(RestAPIError.class);
			throw new RestAPIException(mappedError.toString());
		}

		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new HttpError("HTTP error code: " + response.getStatus());
		}
		
		return response;
	}
	
	public <T> T post(String url, RestRequest<?> input, Class<T> response) {
	    return post(url, input).readEntity(response);
	}
	
	private static ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return mapper;
	}
	
	private static ClientConfig getClientConfig() {
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		provider.setMapper(getObjectMapper());
		return new ClientConfig().register(provider);
	}

}
