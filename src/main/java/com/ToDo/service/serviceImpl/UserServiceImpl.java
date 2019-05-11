package com.ToDo.service.serviceImpl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ToDo.model.User;
import com.ToDo.repository.UsersRepository;
import com.ToDo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UsersRepository userRepository;

	Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	public User createUser(User user) {
		
		if(user.getPassword() == null) {
			logger.error("Password can not be empty.");
			throw new InvalidPasswordException("Password can not be empty.");
			
		} else if(user.getPassword().length()<8) {
			throw new InvalidPasswordException("Invalid password. minimum password length must be 8 characters.");
		}
		
		if(user.getUsername() == null) {
			throw new UserNotFoundException("Username is empty.");
		}
		return userRepository.saveAndFlush(user);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public User getUser(Long id) {
		
		User user = userRepository.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("User id " + id + " not found");
		}
		return user;
	}

	public User updateUser(User user) {
		Long userId = user.getId();
		if(userId==null) {
			throw new FieldRequiredException("User id required");
		}
		User existingUser = userRepository.findOne(userId);
		if(existingUser == null) {
			System.out.println("User: " + user.getId() + " doesn't exist");
			throw new UserNotFoundException("User id " + user.getId() + " not found");
		}
		BeanUtils.copyProperties(user, existingUser);
		return userRepository.saveAndFlush(user);
	}

	public User deleteUser(Long id) {
		User existingUser = userRepository.findOne(id);
		if(existingUser == null) {
			System.out.println("user doesn't exist");
			throw new UserNotFoundException("User id " + id + " not found");
		}
		userRepository.delete(existingUser);
		return existingUser;
	}
}
