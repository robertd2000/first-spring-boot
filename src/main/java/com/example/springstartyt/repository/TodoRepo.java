package com.example.springstartyt.repository;

import com.example.springstartyt.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TaskEntity, Long> {
}
