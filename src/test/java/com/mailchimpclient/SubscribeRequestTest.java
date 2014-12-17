package com.mailchimpclient;

import com.mailchimpclient.domain.MergeField;
import com.mailchimpclient.domain.Subscriber;
import com.mailchimpclient.request.SubscribeRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubscribeRequestTest {

    @Test
    public void subscribeRequestBuilderTest() {
        String listId = "listId123";
        String firstName = "firstName";
        String lastName = "lastName";
        String email = "my@email.com";
        Subscriber subscriber = new Subscriber(firstName, lastName, email, new MergeField("example", "value"));

        SubscribeRequest request = SubscribeRequest.build(listId, subscriber);

        assertEquals(firstName, request.getMergeVars().get("Fname"));
        assertEquals(lastName, request.getMergeVars().get("Lname"));
        assertEquals(email, request.getMergeVars().get("Email"));
        assertEquals(email, request.getEmail().getEmail());
        assertEquals(listId, request.getId());
        assertEquals("value", request.getMergeVars().get("example"));
    }

}
