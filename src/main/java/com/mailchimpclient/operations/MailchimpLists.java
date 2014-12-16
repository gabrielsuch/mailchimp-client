package com.mailchimpclient.operations;

import com.mailchimpclient.MailchimpClient;
import com.mailchimpclient.RestRequest;
import com.mailchimpclient.domain.MergeField;
import com.mailchimpclient.domain.Subscriber;
import com.mailchimpclient.request.SubscribeRequest;

public class MailchimpLists extends MailchimpOperations {
	
	public MailchimpLists(MailchimpClient client) {
		super(client);
	}

	/**
	 * Subscribe the provided email to a list. 
	 * 
	 */
	public void subscribe(String listId, Subscriber subscribe, MergeField... mergeFields) {
		String path = "lists/subscribe.json";
		getMailchimpClient().execute(subscribeOperation(listId, subscribe, path));
	}
	
	/**
	 *  Unsubscribe the given email address from the list
	 *  
	 */
	public void unsubscribe(String listId, Subscriber subscribe, MergeField... mergeFields) {
		String path = "lists/unsubscribe.json";
		getMailchimpClient().execute(subscribeOperation(listId, subscribe, path));
	}
	
	private RestRequest<SubscribeRequest> subscribeOperation(String listId, Subscriber subscribe, String path) {
		SubscribeRequest subscribeRequest = SubscribeRequest.build(listId, subscribe);
		return new RestRequest<SubscribeRequest>(path, subscribeRequest);
	}
	
}
