package com.mailchimpclient;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import com.mailchimpclient.domain.Subscribe;
import com.mailchimpclient.operations.ListsOperations;

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
		Subscribe subscribe = new Subscribe("Gabriel", "Such", "gabrielsuch@gmail.com");
		
		ListsOperations listsOperations = new ListsOperations(client);
		listsOperations.subscribe(listId, subscribe);
		listsOperations.unsubscribe(listId, subscribe);
	}
	
}
