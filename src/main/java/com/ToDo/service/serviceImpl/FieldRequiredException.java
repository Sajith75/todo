package com.ToDo.service.serviceImpl;

import com.ToDo.exception.AppException;

public class FieldRequiredException extends AppException{
	
	public FieldRequiredException() {
		
	}

	public FieldRequiredException(String  message) {
		super(message);
	}

}
