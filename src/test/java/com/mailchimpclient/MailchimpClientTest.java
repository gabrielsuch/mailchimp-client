package com.mailchimpclient;

import org.junit.Test;

import com.mailchimpclient.exception.InvalidAPIKeyException;
import com.mailchimpclient.exception.InvalidAPIRequestException;

public class MailchimpClientTest {
	
	@Test(expected = InvalidAPIKeyException.class)
	public void clientShouldNotBeCreatedWithANullAPIKey() {
		new MailchimpClient(null);
	}
	
	@Test(expected = InvalidAPIKeyException.class)
	public void clientShouldNotBeCreatedWithAInvalidApiKey() {
		new MailchimpClient("123456");
	}
	
	@Test
	public void clientShouldBeCreatedWithAValidApiKey() {
		new MailchimpClient("123456789-us1");
	}
	
	@Test(expected = InvalidAPIRequestException.class)
	public void invalidRequestsShouldNotCallTheRestAPI() {
		new MailchimpClient("123456789-us1").execute(null);
	}

}
