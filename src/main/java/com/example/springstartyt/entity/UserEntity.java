package com.example.springstartyt.entity;

import javax.annotation.Generated;
import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TaskEntity> todos;

    public UserEntity() {

    }

    public List<TaskEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TaskEntity> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
