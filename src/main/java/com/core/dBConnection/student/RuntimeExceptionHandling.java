package com.core.dBConnection.student;

public class RuntimeExceptionHandling extends RuntimeException {

	int statusCode;
	String message;
	
	public RuntimeExceptionHandling(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
}
