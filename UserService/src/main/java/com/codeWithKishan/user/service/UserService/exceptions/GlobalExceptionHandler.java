package com.codeWithKishan.user.service.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codeWithKishan.user.service.UserService.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException( ResourceNotFoundException exception){
		String message = exception.getMessage();
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(message);
		apiResponse.setSuccess(true);
		apiResponse.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
}
