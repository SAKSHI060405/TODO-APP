package com.todo.start.controller;


import com.todo.start.config.JwtUtil;
import com.todo.start.dto.LoginRequest;
import com.todo.start.dto.LoginResponse;
import com.todo.start.models.UserModel;
import com.todo.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            UserModel user = userService.authenticateUser(
                loginRequest.getUsername(), 
                loginRequest.getPassword()
            );
            
            String token = jwtUtil.generateToken(
                user.getUsername(), 
                user.getId(), 
                user.getRole()
            );
            
            LoginResponse response = new LoginResponse(
                token, 
                user.getUsername(), 
                user.getRole(), 
                user.getId()
            );
            
            return ResponseEntity.ok(response);
            
        } catch (RuntimeException e) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}