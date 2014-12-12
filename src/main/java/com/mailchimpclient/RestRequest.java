package com.mailchimpclient;

public class RestRequest<T> {
	
	private final String path;
	private final T body;
	
	public RestRequest(String path, T body) {
		this.path = path;
		this.body = body;
	}
	
	public String getPath() {
		return path;
	}
	
	public T getBody() {
		return body;
	}

}
