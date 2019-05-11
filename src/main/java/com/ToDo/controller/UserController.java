package com.ToDo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ToDo.model.User;
import com.ToDo.service.UserService;

@RestController
@RequestMapping("api/v2")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "users/list", method = RequestMethod.GET)
	public List<User> list(){
		return userService.getUsers();		
	}
	
	@RequestMapping(value = "users/user", method = RequestMethod.POST)
	public User create(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public User get(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Long id, @RequestBody User user) {		
		return userService.updateUser(user);
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public User delete(@PathVariable Long id) {	
		return userService.deleteUser(id);
	}
}
