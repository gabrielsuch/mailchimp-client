package com.mailchimpclient.domain;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {
	
	private String firstName;
	private String lastName;
	private String email;
	private List<MergeField> mergeFields = new ArrayList<MergeField>();
	
	public Subscriber(String firstName, String lastName, String email, MergeField... mergeFields) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
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
