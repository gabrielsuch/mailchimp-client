package com.mailchimpclient;

import com.mailchimpclient.exception.InvalidAPIRequestException;
import com.mailchimpclient.request.MailchimpRequest;

public class MailchimpClient {

	private final MailchimpAPIKey apiKey;
	private final RestClient client;

	public MailchimpClient(MailchimpAPIKey apiKey, RestClient client) {
		this.apiKey = apiKey;
		this.client = client;
	}

	public MailchimpClient(String apiKey, RestClient client) {
		this(new MailchimpAPIKey(apiKey), client);
	}

	public MailchimpClient(String apiKey) {
		this(apiKey, new RestClient());
	}

	public void execute(RestRequest<? extends MailchimpRequest<?>> request) {
        validateMailchimpRequest(request);
		client.post(apiKey.getEndpoint(), apiKey.getAuthenticatedRequest(request));
	}
	
	public <T> T execute(RestRequest<? extends MailchimpRequest<?>> request, Class<T> response) {
	    validateMailchimpRequest(request);
        return client.post(apiKey.getEndpoint(), apiKey.getAuthenticatedRequest(request), response);
	}
	
	private void validateMailchimpRequest(RestRequest<?> request) {
        if (request == null || request.getBody() == null) {
            throw new InvalidAPIRequestException();
        }
	}

}
