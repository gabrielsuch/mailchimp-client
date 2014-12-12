package com.mailchimpclient.domain;

public class Subscribe {
	
	private String firstName;
	private String lastName;
	private String email;
	
	public Subscribe(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

}
