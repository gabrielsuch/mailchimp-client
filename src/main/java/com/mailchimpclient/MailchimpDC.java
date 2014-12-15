package com.mailchimpclient;

import com.mailchimpclient.exception.InvalidAPIKeyException;

public class MailchimpDC {

	private static final String API_URI = "https://%s.api.mailchimp.com/2.0/";
	private final String dc;

	private MailchimpDC(String dc) {
		this.dc = dc;
	}

	public String getEndpoint() {
		return String.format(API_URI, dc.toLowerCase());
	}

	public static MailchimpDC fromApiKey(String apiKey) {
		if (apiKey == null) {
			throw new InvalidAPIKeyException("APIKey is required");
		}

		String[] split = apiKey.split("-");

		if (split.length != 2) {
			throw new InvalidAPIKeyException("Invalid APIKey format");
		}

		return new MailchimpDC(split[1]);
	}

}
