package com.example.demo.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.data.UserDataService;
import com.example.demo.data.entity.UserEntity;
import com.example.demo.model.UserModel;

public class UserBusinessService implements UserBusinessInterface{

    @Autowired
    private UserDataService service;

    @Override
    public List<UserModel> getUser() {
        List<UserEntity> userEntity = service.findAll();

        List<UserModel> userDomain = new ArrayList<UserModel>();

        for (UserEntity entity : userEntity)
        {
            userDomain.add(new UserModel(entity.getId(), entity.getEmail(), entity.getUserName()));
        }

        return userDomain;
    }

    @Override
    public boolean addUser(UserModel userModel) {
        UserEntity entity = new UserEntity(null, userModel.getEmail(), userModel.getUserName());
        return service.create(entity);
    }

    @Override
    public UserModel getUserById(int id) {
        UserEntity entity = service.findById(id);
        return new UserModel(entity.getId(), entity.getEmail(), entity.getUserName()) ;
    }

    @Override
    public boolean deleteUser(UserModel userModel) {
        UserEntity entity = new UserEntity(userModel.getId(), userModel.getEmail(), userModel.getUserName());
        return service.delete(entity);
    }

    @Override
    public boolean updateUser(UserModel userModel) {
        UserEntity entity = new UserEntity(userModel.getId(), userModel.getEmail(), userModel.getUserName());
        return service.update(entity);
    }
    
}
