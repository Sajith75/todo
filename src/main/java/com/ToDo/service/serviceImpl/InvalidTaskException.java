package com.ToDo.service.serviceImpl;

import com.ToDo.exception.AppException;

public class InvalidTaskException extends AppException{
	public InvalidTaskException() {
		
	}
	
	public InvalidTaskException(String message) {
		super(message);
	}
}
