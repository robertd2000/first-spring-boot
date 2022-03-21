package com.example.springstartyt.service;

import com.example.springstartyt.entity.TaskEntity;
import com.example.springstartyt.entity.UserEntity;
import com.example.springstartyt.model.TodoModel;
import com.example.springstartyt.repository.TodoRepo;
import com.example.springstartyt.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public TodoModel createTodo(TaskEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return TodoModel.todoModel(todoRepo.save(todo));
    }

    public TodoModel completeTodo(Long id) {
        TaskEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return TodoModel.todoModel(todoRepo.save(todo));
    }
}
