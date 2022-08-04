package com.example.demo.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.data.UserDataService;
import com.example.demo.data.entity.UserEntity;
import com.example.demo.model.UserModel;

public class UserBusinessService implements UserBusinessInterface{

    Logger logger = LogManager.getLogger(UserBusinessService.class);

    @Autowired
    private UserDataService service;

    @Override
    public List<UserModel> getUser() {
        logger.info("INFO: entering getUser method...");

        logger.info("Info: retrieving user data using UserDataService...");
        List<UserEntity> userEntity = service.findAll();

        List<UserModel> userDomain = new ArrayList<UserModel>();

        for (UserEntity entity : userEntity)
        {
            userDomain.add(new UserModel(entity.getId(), entity.getEmail(), entity.getUserName()));
        }

        logger.info("INFO: exiting getUserMethod...");
        return userDomain;
    }

    @Override
    public boolean addUser(UserModel userModel) {
        logger.info("INFO: entering addUser method...");
        logger.info("INFO: adding new UserEntity to database using UserDataService");
        logger.info("New UserEntity: \nUsername: " + userModel.getUserName() + ",\nEmail: " + userModel.getEmail());
        UserEntity entity = new UserEntity(null, userModel.getEmail(), userModel.getUserName());
        logger.info("INFO: exiting addUser method...");
        return service.create(entity);
    }

    @Override
    public UserModel getUserById(int id) {
        logger.info("INFO: entering getUserById method...");
        UserEntity entity = service.findById(id);
        logger.info("Found UserEntity: \nUsername: " + entity.getUserName() + ", \nEmail: " + entity.getEmail());
        logger.info("INFO: exiting getUserById method...");
        return new UserModel(entity.getId(), entity.getEmail(), entity.getUserName()) ;
    }

    @Override
    public boolean deleteUser(UserModel userModel) {
        logger.info("INFO: entering deleteUser method");
        UserEntity entity = new UserEntity(userModel.getId(), userModel.getEmail(), userModel.getUserName());
        logger.info("Removing UserEntity: \nUsername: " + entity.getUserName() + ", \nEmail: " + entity.getEmail());
        logger.info("INFO: exiting deleteUser method...");
        return service.delete(entity);
    }

    @Override
    public boolean updateUser(UserModel userModel) {
        logger.info("INFO: entering updateUser method");
        UserEntity entity = new UserEntity(userModel.getId(), userModel.getEmail(), userModel.getUserName());
        logger.info("Updating UserEntity: \nUsername: " + entity.getUserName() + ", \nEmail: " + entity.getEmail());
        logger.info("INFO: exiting updateUser method...");
        return service.update(entity);
    }
    
}
