package com.todo.start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.start.models.TodoModel;
import com.todo.start.service.TodoService;


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

@PutMapping
public TodoModel updateTodo(@RequestBody TodoModel todo) {
    return todoService.updateTodo(todo);
}

@DeleteMapping("/{id}")
public String deleteTodo(@PathVariable Long id) {
    todoService.deleteTodo(id.toString());
    return "Todo deleted successfully";
}
@PostMapping("/bulk")
public List<TodoModel> createBulkTodos(@RequestBody List<TodoModel> todos) {
    return todoService.createBulkTodos(todos);
}
@PutMapping("/bulk")
public List<TodoModel> updateBulkTodos(@RequestBody List<TodoModel> todos) {
    return todoService.updateBulkTodos(todos);
}

@DeleteMapping("/bulkdelete")
public String deleteBulkTodos(@RequestBody List<String> ids) {
    todoService.deleteBulkTodos(ids);
    return "Bulk delete successful";
}

}
