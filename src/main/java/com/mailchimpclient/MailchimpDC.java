package com.mailchimpclient;

import com.mailchimpclient.exception.InvalidAPIKeyException;

public class MailchimpDC {

	private static final String API_URI = "https://%s.api.mailchimp.com/2.0/";
	private final String dc;

	public MailchimpDC(String dc) {
		if (dc == null || !dc.matches("[a-z]{2}\\d{1,2}")) {
			throw new InvalidAPIKeyException("Invalid DC Format");
		}

		this.dc = dc;
	}

	public String getEndpoint() {
		return String.format(API_URI, dc.toLowerCase());
	}

}
