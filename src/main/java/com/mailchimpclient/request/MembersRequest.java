package com.mailchimpclient.request;

public class MembersRequest extends MailchimpRequest<String> {
    
    private String id;
    
    public MembersRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    void loadRequest(String entity) {
        this.id = entity;
    }

}
