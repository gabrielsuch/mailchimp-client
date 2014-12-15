package com.mailchimpclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.mailchimpclient.exception.RestAPIException;
import com.mailchimpclient.response.RestAPIError;

public class RestClient {
	
	private final Client client = ClientBuilder.newClient(getClientConfig());
	
	public <T> void post(String url, RestRequest<?> input) {
		try {
			Response response = client.target(url).path(input.getPath())
		             .request()
		             .post(Entity.entity(input.getBody(), MediaType.APPLICATION_JSON));
			
			if (response.getStatus() == 500) {
				RestAPIError mappedError = response.readEntity(RestAPIError.class);
				throw new RestAPIException(mappedError.toString());
			}
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code: " + response.getStatus());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		return mapper;
	}
	
	private ClientConfig getClientConfig() {
		JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
		provider.setMapper(getObjectMapper());
		return new ClientConfig().register(provider);
	}

}
