package com.todo.start.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TodoModel {
    @Id
    private String id;
    private String content;

    public TodoModel(String id, String content) {
        this.id = id;
        this.content = content;
    }
    public TodoModel(){
        this.id = null;
        this.content = null;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
