package com.todo.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.start.models.TodoModel;
import com.todo.start.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired // Injecting the TodoService
    private TodoService todoService; // Service layer to handle business logic

    @PostMapping
    public TodoModel createTodo(@RequestBody TodoModel todo){
    return todoService.createTodo(todo); // Delegating the creation to the service layer
    }


    //get all todos API
@GetMapping("/getall")
public List<TodoModel> getAllTodos() {
    return todoService.getList();
}

}
