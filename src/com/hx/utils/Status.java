package com.hx.utils;

public class Status {

	int status = -1;// 0 success
	String message;
	Object data;

	public Status(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Status(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Status(int status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	public Status(int status) {
		super();
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
