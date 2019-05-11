package com.ToDo.service;

import java.util.List;

import com.ToDo.model.ToDoList;

public interface TaskService {
	
	public ToDoList createTask(ToDoList toDoList);
	
	public List<ToDoList> getToDoList();
	
	public ToDoList getTask(long id);
	
	public ToDoList updateTask(ToDoList toDoList);
	
	public ToDoList deleteTask(Long id);

}
