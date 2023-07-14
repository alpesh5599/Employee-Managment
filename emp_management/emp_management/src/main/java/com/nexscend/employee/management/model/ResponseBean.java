package com.nexscend.employee.management.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseBean {
	
	private Integer statusCode;
    private String message;
    private Object data;
	
    public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
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
	@Override
	public String toString() {
		return "ResponseBean [statusCode=" + statusCode + ", message=" + message + ", data=" + data + "]";
	}
}
