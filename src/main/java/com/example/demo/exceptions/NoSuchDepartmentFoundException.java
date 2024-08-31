package com.example.demo.exceptions;

public class NoSuchDepartmentFoundException extends RuntimeException {
	public NoSuchDepartmentFoundException(String message) {
		super(message);
	}

}
