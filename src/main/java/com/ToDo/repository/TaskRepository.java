package com.ToDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ToDo.model.ToDoList;

public interface TaskRepository extends JpaRepository<ToDoList, Long>{

}
