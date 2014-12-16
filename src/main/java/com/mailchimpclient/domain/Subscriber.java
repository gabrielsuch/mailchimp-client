package com.mailchimpclient.domain;

import java.util.LinkedList;
import java.util.List;

public class Subscriber {
	
	private final String firstName;
	private final String lastName;
	private final String email;
	private final List<MergeField> mergeFields;
	
	public Subscriber(String firstName, String lastName, String email, MergeField... mergeFields) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mergeFields = new LinkedList<MergeField>();
		
		for (MergeField mergeField : mergeFields) {
			this.mergeFields.add(mergeField);
		}
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public List<MergeField> getMergeFields() {
		return mergeFields;
	}

}
