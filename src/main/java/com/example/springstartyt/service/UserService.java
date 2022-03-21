package com.example.springstartyt.service;

import com.example.springstartyt.entity.UserEntity;
import com.example.springstartyt.exceptions.UserAlreadyExist;
import com.example.springstartyt.exceptions.UserNotFound;
import com.example.springstartyt.model.UserModel;
import com.example.springstartyt.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    
    public UserEntity registration(UserEntity user) throws UserAlreadyExist {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExist("Пользователь с таким именем уже существует");
        }

        return userRepo.save(user);
    } 

    public UserModel getOne(Long id) throws UserNotFound {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFound("Пользователь не найден");
        }
        return UserModel.toModel(user);
    }

    public Long deleteuser(Long id) {
        userRepo.deleteById(id);

        return id;
    }
}
