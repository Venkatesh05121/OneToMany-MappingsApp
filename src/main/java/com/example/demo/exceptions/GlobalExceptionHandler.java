package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchDepartmentFoundException.class)
	public ResponseEntity<String> handlerNoSuchDepartmentFoundException(NoSuchDepartmentFoundException ex){
		
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex){
		
		
		return new ResponseEntity<String>("An Unexpected Error Occurrs !", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
