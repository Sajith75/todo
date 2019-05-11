package com.ToDo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@NotNull
	@NotEmpty(message = "Please provide a user name")
	private String username;
	
	
	private String password;

//Do not use this relation, user relation in ToDoList
//	@OneToMany(mappedBy = "user")
//	List<ToDoList> toDoList;

	public User() {
	}

	public User(Long id, String name, String username, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
//	public List<ToDoList> getToDoList() {
//		return toDoList;
//	}
//
//	public void setToDoList(List<ToDoList> toDoList) {
//		this.toDoList = toDoList;
//	}

}
