mailchimp-client
================

A simple and lightweight MailChimp REST client library for Java.


***Code samples***

```java
MailchimpClient client = new MailchimpClient("YOUR_API_KEY");
MailchimpLists lists = new MailchimpLists(client);

Subscriber subscriber = new Subscriber("firstName", "lastName", "email@example.com");
lists.subscribe("listId", subscriber);
list.unsubscribe("listId", subscriber);
```
