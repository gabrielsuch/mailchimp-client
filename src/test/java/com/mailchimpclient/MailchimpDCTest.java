package com.mailchimpclient;

import com.mailchimpclient.exception.InvalidAPIKeyException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MailchimpDCTest {

    @Test(expected = InvalidAPIKeyException.class)
    public void nullShouldNotBeAnValidDC() {
        new MailchimpDC(null);
    }

    @Test(expected = InvalidAPIKeyException.class)
    public void aValidDCShouldNotHaveLessThanTwoLetters() {
        new MailchimpDC("u9");
    }

    @Test(expected = InvalidAPIKeyException.class)
    public void aValidDCShouldNotHaveMoreThanTwoLetters() {
        new MailchimpDC("usi9");
    }

    @Test(expected = InvalidAPIKeyException.class)
    public void aValidDCShouldHaveTwoLettersFollowedByOneNumber() {
        new MailchimpDC("us");
    }

    @Test(expected = InvalidAPIKeyException.class)
    public void aValidDCShouldHaveTwoLettersFollowedByMaxTwoNumbers() {
        new MailchimpDC("us250");
    }

    @Test
    public void aValidDCIsTwoLettersFollowedByOneNumber() {
        new MailchimpDC("us9");
    }

    @Test
    public void orTwoLettersFollowedByTwoNumbers() {
        new MailchimpDC("us10");
    }

    @Test
    public void endpointTest() {
        String expected = "https://uk1.api.mailchimp.com/2.0/";
        assertEquals(expected, new MailchimpDC("uk1").getEndpoint());
    }

}
