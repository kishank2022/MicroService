package com.codeWithKishan.hotelService.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super(" Resource Not Found with this identity details !! ");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
