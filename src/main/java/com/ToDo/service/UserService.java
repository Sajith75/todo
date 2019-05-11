package com.ToDo.service;

import java.util.List;

import com.ToDo.model.User;


public interface UserService {
	
	public User createUser(User user);
	
	public List<User> getUsers();

	public User getUser(Long id);
	
	public User updateUser(User user);
	
	public User deleteUser(Long id);
}
