package com.mailchimpclient;

import com.mailchimpclient.exception.InvalidAPIRequestException;
import com.mailchimpclient.request.MailchimpRequest;


public class MailchimpClient {
	
	private final String apiKey;
	private final MailchimpDC dc;
	private final RestClient client;

	public MailchimpClient(String apiKey, RestClient client) {
		this.apiKey = apiKey;
		this.dc = MailchimpDC.fromApiKey(apiKey);
		this.client = client;
	}
	
	public MailchimpClient(String apiKey) {
		this(apiKey, new RestClient());
	}
	
	public void execute(RestRequest<? extends MailchimpRequest<?>> request) {
		if (request == null || request.getBody() == null) {
			throw new InvalidAPIRequestException();
		}
			
		request.getBody().setApikey(apiKey);
		client.post(dc.getEndpoint(), request);
	}

}
