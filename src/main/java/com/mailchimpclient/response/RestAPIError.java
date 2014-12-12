package com.mailchimpclient.response;

public class RestAPIError {

	private String status;
	private String code;
	private String name;
	private String error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "RestAPIError [status=" + status + ", code=" + code + ", name=" + name + ", error=" + error + "]";
	}

}
