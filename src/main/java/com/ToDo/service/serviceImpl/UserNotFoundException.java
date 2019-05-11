package com.ToDo.service.serviceImpl;

import com.ToDo.exception.AppException;

public class UserNotFoundException extends AppException{
	
	public UserNotFoundException() {
		
	}

	public UserNotFoundException(String  message) {
		super(message);
	}

}
