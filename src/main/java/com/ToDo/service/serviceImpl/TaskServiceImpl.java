package com.ToDo.service.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ToDo.model.ToDoList;
import com.ToDo.repository.TaskRepository;
import com.ToDo.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	@Autowired
	private TaskRepository taskRepository;
	
	public ToDoList createTask(ToDoList toDoList) {
		if(toDoList.getName() == null) {
			System.out.println("task name can not be null.");
		}
		return taskRepository.saveAndFlush(toDoList);
	}
	
	public List<ToDoList> getToDoList(){
		return taskRepository.findAll();
	}
	
	public ToDoList getTask(long id) {
		ToDoList toDoList = taskRepository.findOne(id);
		if(toDoList==null) {
			throw new InvalidTaskException("Task name can not be empty.");
		}
		return toDoList;
	}
	
	public ToDoList updateTask(ToDoList toDoList) {
		ToDoList existingTask = taskRepository.findOne(toDoList.getId());
		if(existingTask == null) {
			throw new InvalidTaskException("task doesn't exist");
		}
		BeanUtils.copyProperties(toDoList, existingTask);
		return taskRepository.saveAndFlush(toDoList);
	}
	
	public ToDoList deleteTask(Long id) {
		ToDoList existingTask = taskRepository.findOne(id);
		if(existingTask == null) {
			throw new InvalidTaskException("task doesn't exist");
		}
		taskRepository.delete(existingTask);
		return existingTask;
	}
	
}
