package com.ToDo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="todolist")
public class ToDoList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@NotEmpty(message = "Pleaser enter a task item.")
	private String name;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id" )
	private User user;
	
	public ToDoList() {}
	
	public ToDoList(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	

	public ToDoList(String name, String description, User user) {
		super();
		this.name = name;
		this.description = description;
		this.user = user;
	}

	public ToDoList(Long id, String name, String description, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.user = user;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
}
