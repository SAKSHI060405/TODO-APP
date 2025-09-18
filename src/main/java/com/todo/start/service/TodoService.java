package com.todo.start.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.start.models.TodoModel;


@Service
public class TodoService {

    private List<TodoModel> list = new ArrayList<>(); // In-memory list to store todos temporarily

    // Method to create a new todo

    public TodoModel createTodo(TodoModel todo) {
        list.add(todo);
        return todo;
    }

    // Method to get all todos
    public List<TodoModel> getList() {
        return list;
    }
        // PUT: Update a todo
    public TodoModel updateTodo(TodoModel todo) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(todo.getId())) {
                list.set(i, todo);
                return todo;
            }
        }
        return null; // or throw an exception if not found
    }
        // DELETE: Remove a todo by ID
    public void deleteTodo(Long id) {
        list.removeIf(t -> t.getId().equals(id));
    }

    // Method to create multiple todos in bulk
    public List<TodoModel> createBulkTodos(List<TodoModel> todos) {
        list.addAll(todos);
        return todos;
    }
    // Method to update multiple todos in bulk
    public List<TodoModel> updateBulkTodos(List<TodoModel> todos) {
        for (TodoModel todo : todos) {
            updateTodo(todo); // Reusing the single update method
        }
        return todos;
    }
    // Method to delete multiple todos in bulk by their IDs
    public void deleteBulkTodos(List<String> ids) {
    list.removeIf(todo -> ids.contains(todo.getId()));
}
}