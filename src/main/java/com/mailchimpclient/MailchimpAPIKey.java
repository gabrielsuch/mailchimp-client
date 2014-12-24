package com.mailchimpclient;

import com.mailchimpclient.exception.InvalidAPIKeyException;
import com.mailchimpclient.request.MailchimpRequest;

public class MailchimpAPIKey {

    private final String apiKey;
    private final MailchimpDC dc;

    public MailchimpAPIKey(String apiKey) {
        if (apiKey == null || apiKey.split("-").length != 2) {
            throw new InvalidAPIKeyException("Invalid APIKey");
        }

        this.apiKey = apiKey;
        this.dc = new MailchimpDC(apiKey.split("-")[1]);
    }

    public <T extends MailchimpRequest<?>> RestRequest<T> getAuthenticatedRequest(RestRequest<T> request) {
        request.getBody().setApikey(apiKey);
        return request;
    }

    public String getEndpoint() {
        return dc.getEndpoint();
    }

}
