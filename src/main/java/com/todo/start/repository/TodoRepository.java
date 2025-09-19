package com.todo.start.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.start.models.TodoModel;

public interface TodoRepository extends JpaRepository<TodoModel, String> {

}
