package com.example.springstartyt.repository;

import com.example.springstartyt.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
