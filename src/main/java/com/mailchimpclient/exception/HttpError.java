package com.mailchimpclient.exception;

public class HttpError extends MailchimpClientException {

    private static final long serialVersionUID = 1L;

    public HttpError(String message) {
        super(message);
    }

}
