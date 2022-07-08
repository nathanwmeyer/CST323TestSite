package com.example.demo.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.data.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
    
}
