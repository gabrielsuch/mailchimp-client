package com.mailchimpclient;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import com.mailchimpclient.domain.Subscriber;
import com.mailchimpclient.operations.MailchimpLists;

public class MailchimpSubscriptionTest {
	
	private String apiKey;
	private String listId;
	
	@Before
	public void setup() {
		ResourceBundle rb = ResourceBundle.getBundle("config"); // It requires a config.properties under src/test/resources
		apiKey = rb.getString("API_KEY");
		listId = rb.getString("LIST_ID");
	}
	
	@Test
	public void subscribeList() {
		MailchimpClient client = new MailchimpClient(apiKey);
		Subscriber subscribe = new Subscriber("Gabriel", "Such", "gabrielsuch@gmail.com");
		
		MailchimpLists listsOperations = new MailchimpLists(client);
		listsOperations.subscribe(listId, subscribe);
		listsOperations.unsubscribe(listId, subscribe);
	}
	
}
