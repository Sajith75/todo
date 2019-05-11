package com.ToDo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ToDo.model.ToDoList;
import com.ToDo.service.TaskService;

@RestController
@RequestMapping("api/v2/")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "todolist/list", method = RequestMethod.GET)
	public List<ToDoList> list(){
		return taskService.getToDoList();
	}

	@RequestMapping(value = "todolist/task", method = RequestMethod.POST)
    public ToDoList create(@Valid @RequestBody ToDoList toDoList){
        return taskService.createTask(toDoList);
    }
	
	@RequestMapping(value = "todolist/{id}", method = RequestMethod.GET)
    public ToDoList get(@PathVariable Long id){
        return taskService.getTask(id);
    }
	
	@RequestMapping(value = "todolist/{id}", method = RequestMethod.PUT)
    public ToDoList update(@PathVariable Long id, @RequestBody ToDoList toDoList){		
        return taskService.updateTask(toDoList);
    }
	
	@RequestMapping(value = "todolist/{id}", method = RequestMethod.DELETE)
    public ToDoList delete(@PathVariable Long id){
		return taskService.deleteTask(id);
    }

}
