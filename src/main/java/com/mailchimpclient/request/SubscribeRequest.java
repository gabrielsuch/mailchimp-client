package com.mailchimpclient.request;

import com.mailchimpclient.domain.Subscribe;

public class SubscribeRequest extends MailchimpRequest<Subscribe> {
	
	private String id;
	private EmailRequest email = new EmailRequest();
	private MergeVarsRequest mergeVars = new MergeVarsRequest();
	private boolean updateExisting = true;
	private boolean doubleOptin = false;
	
	private SubscribeRequest(String listId) {
		this.id = listId;
	}

	@Override
	public void loadRequest(Subscribe entity) {
		email.setEmail(entity.getEmail());
		mergeVars.setFname(entity.getFirstName());
		mergeVars.setLname(entity.getLastName());
		mergeVars.setEmail(entity.getEmail());
	}
	
	public String getId() {
		return id;
	}
	
	public EmailRequest getEmail() {
		return email;
	}
	
	public MergeVarsRequest getMergeVars() {
		return mergeVars;
	}
	
	public boolean isUpdateExisting() {
		return updateExisting;
	}
	
	public boolean isDoubleOptin() {
		return doubleOptin;
	}
	
	public static SubscribeRequest build(String listId, Subscribe subscribe) {
		SubscribeRequest request = new SubscribeRequest(listId);
		request.loadRequest(subscribe);
		return request;
	}

}
