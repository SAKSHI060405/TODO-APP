package com.todo.start.dto;


public class LoginResponse {
    private String token;
    private String username;
    private String role;
    private String userId;
    
    // Default constructor
    public LoginResponse() {}
    
    // Constructor
    public LoginResponse(String token, String username, String role, String userId) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.userId = userId;
    }
    
    // Getters and setters (needed for JSON serialization)
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
}