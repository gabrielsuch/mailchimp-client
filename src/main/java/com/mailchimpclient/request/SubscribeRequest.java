package com.mailchimpclient.request;

import java.util.HashMap;
import java.util.Map;

import com.mailchimpclient.domain.MergeField;
import com.mailchimpclient.domain.Subscriber;

public class SubscribeRequest extends MailchimpRequest<Subscriber> {
	
	private String id;
	private EmailRequest email = new EmailRequest();
	private Map<String, Object> mergeVars = new HashMap<String, Object>();
	private boolean updateExisting = true;
	private boolean doubleOptin = false;
	
	private SubscribeRequest(String listId) {
		this.id = listId;
	}

	@Override
	public void loadRequest(Subscriber entity) {
		email.setEmail(entity.getEmail());
		
		mergeVars.put("Fname", entity.getFirstName());
		mergeVars.put("Lname", entity.getLastName());
		mergeVars.put("Email", entity.getEmail());
		
		for (MergeField mergeField : entity.getMergeFields()) {
			mergeVars.put(mergeField.getField(), mergeField.getValue());
		}
	}
	
	public String getId() {
		return id;
	}
	
	public EmailRequest getEmail() {
		return email;
	}
	
	public Map<String, Object> getMergeVars() {
		return mergeVars;
	}
	
	public boolean isUpdateExisting() {
		return updateExisting;
	}
	
	public boolean isDoubleOptin() {
		return doubleOptin;
	}
	
	public static SubscribeRequest build(String listId, Subscriber subscribe) {
		SubscribeRequest request = new SubscribeRequest(listId);
		request.loadRequest(subscribe);
		return request;
	}

}
