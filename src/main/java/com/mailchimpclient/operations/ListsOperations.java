package com.mailchimpclient.operations;

import com.mailchimpclient.MailchimpClient;
import com.mailchimpclient.RestRequest;
import com.mailchimpclient.domain.Subscribe;
import com.mailchimpclient.request.SubscribeRequest;

public class ListsOperations extends MailchimpOperations {
	
	public ListsOperations(MailchimpClient client) {
		super(client);
	}

	/**
	 * Subscribe the provided email to a list. 
	 * 
	 */
	public void subscribe(String listId, Subscribe subscribe) {
		String path = "lists/subscribe.json";
		getMailchimpClient().execute(subscribeOperation(listId, subscribe, path));
	}
	
	/**
	 *  Unsubscribe the given email address from the list
	 *  
	 */
	public void unsubscribe(String listId, Subscribe subscribe) {
		String path = "lists/unsubscribe.json";
		getMailchimpClient().execute(subscribeOperation(listId, subscribe, path));
	}
	
	private RestRequest<SubscribeRequest> subscribeOperation(String listId, Subscribe subscribe, String path) {
		SubscribeRequest subscribeRequest = SubscribeRequest.build(listId, subscribe);
		return new RestRequest<SubscribeRequest>(path, subscribeRequest);
	}
	
}
