package com.mailchimpclient.exception;

public class InvalidAPIKeyException extends MailchimpClientException {

	private static final long serialVersionUID = 1L;
	
    public InvalidAPIKeyException(String message) {
        super(message);
    }

}
