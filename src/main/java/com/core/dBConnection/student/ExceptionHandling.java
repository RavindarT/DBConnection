package com.core.dBConnection.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(RuntimeExceptionHandling.class)
	public ResponseEntity<ErrorMessageDetails> handleException(RuntimeExceptionHandling customExceptionHandling){
		ErrorMessageDetails errorMessageDetails = new ErrorMessageDetails(customExceptionHandling.statusCode, customExceptionHandling.message);
		return new ResponseEntity<>(errorMessageDetails, HttpStatus.valueOf(404));
	}
	
}
