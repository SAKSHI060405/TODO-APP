package com.todo.start.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.start.models.TodoModel;
import com.todo.start.repository.TodoRepository;


@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    // Method to create a new todo

    public TodoModel createTodo(TodoModel todo) {
        return todoRepository.save(todo);
    }

    // Method to get all todos
    public List<TodoModel> getList() {
        return todoRepository.findAll();
    }
        // PUT: Update a todo
    public TodoModel updateTodo(TodoModel todo) {
        return todoRepository.save(todo);
    }
        // DELETE: Remove a todo by ID
    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }

    // Method to create multiple todos in bulk
    public List<TodoModel> createBulkTodos(List<TodoModel> todos) {
        return todoRepository.saveAll(todos);
    }
    // Method to update multiple todos in bulk
    public List<TodoModel> updateBulkTodos(List<TodoModel> todos) {
        return todoRepository.saveAll(todos);
    }
    // Method to delete multiple todos in bulk by their IDs
    public void deleteBulkTodos(List<String> ids) {
        ids.forEach(todoRepository::deleteById);
}
}