package com.ToDo.service.serviceImpl;

import com.ToDo.exception.AppException;

public class InvalidPasswordException extends AppException{
	public InvalidPasswordException() {
		
	}
	
	public InvalidPasswordException(String message) {
		super(message);
	}
}
