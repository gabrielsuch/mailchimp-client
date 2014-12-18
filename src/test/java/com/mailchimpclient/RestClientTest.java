package com.mailchimpclient;

import com.mailchimpclient.exception.HttpError;
import com.mailchimpclient.exception.RestAPIException;
import com.mailchimpclient.response.RestAPIError;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RestClientTest {

    private RestClient restClient;
    private Response response;

    @Before
    public void setup() {
        Client client = mock(Client.class);
        response = mock(Response.class);

        WebTarget webTarget = mock(WebTarget.class);
        Invocation.Builder builder = mock(Invocation.Builder.class);
        when(client.target(anyString())).thenReturn(webTarget);
        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);

        when(builder.post(any(Entity.class))).thenReturn(response);
        restClient = new RestClient(client);
    }

    @Test
    public void testSuccessfulRequest() {
        when(response.getStatus()).thenReturn(200);
        restClient.post("url", mock(RestRequest.class));
    }

    @Test
    public void testMailchimpKnowingError() {
        RestAPIError error = new RestAPIError("status", "code", "name", "error");
        when(response.getStatus()).thenReturn(500);
        when(response.readEntity(RestAPIError.class)).thenReturn(error);

        try {
            restClient.post("url", mock(RestRequest.class));
            Assert.fail();
        } catch (RestAPIException e) {
            assertEquals(e.getMessage(), error.toString());
        }
    }

    @Test(expected = HttpError.class)
    public void testHttpUnknownError() {
        when(response.getStatus()).thenReturn(404);
        restClient.post("url", mock(RestRequest.class));
    }

}
