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

	public MailchimpClient(MailchimpAPIKey apiKey) {
		this(apiKey, new RestClient());
	}

	public void execute(RestRequest<? extends MailchimpRequest<?>> request) {
		if (request == null || request.getBody() == null) {
			throw new InvalidAPIRequestException();
		}

		client.post(apiKey.getEndpoint(), apiKey.authenticate(request));
	}

}
