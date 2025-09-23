package com.todo.start;

import com.todo.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    @Autowired
    private UserService userService; // Inject UserService to initialize default users

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override 
    public void run(String... args) throws Exception {
        // Initialize default users on startup
        userService.initializeDefaultUsers();
    }
}
