package com.mailchimpclient;

import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;

import com.mailchimpclient.domain.MergeField;
import com.mailchimpclient.domain.Subscriber;
import com.mailchimpclient.operations.MailchimpLists;

public class MailchimpSubscriptionTest {
	
	private MailchimpLists listsOperations;
	private String listId;
	
	@Before
	public void setup() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String apiKey = rb.getString("API_KEY");
		listId = rb.getString("LIST_ID");

		MailchimpClient client = new MailchimpClient(apiKey);
		listsOperations = new MailchimpLists(client);
	}
	
	@Test
	public void subscribeList() {
		listsOperations.subscribe(listId, subscriber());
	}

	@Test
	public void unsubscribeList() {
		listsOperations.subscribe(listId, subscriber());
		listsOperations.unsubscribe(listId, subscriber());
	}

	private Subscriber subscriber() {
		return new Subscriber("Gabriel", "Such", "gabrielsuch@gmail.com", new MergeField("State", "CA"));
	}
	
}
