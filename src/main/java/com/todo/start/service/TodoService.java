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
}
