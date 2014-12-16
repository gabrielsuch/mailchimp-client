package com.mailchimpclient.domain;

public class MergeField {

	private final String field;
	private final Object value;
	
	public MergeField(String field, Object value) {
		this.field = field;
		this.value = value;
	}
	
	public String getField() {
		return field;
	}
	
	public Object getValue() {
		return value;
	}
	
}
