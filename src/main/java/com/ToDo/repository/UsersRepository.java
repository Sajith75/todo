package com.ToDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ToDo.model.User;

public interface UsersRepository extends JpaRepository<User, Long>{

}
