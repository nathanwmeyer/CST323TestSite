package com.example.demo.business;

import java.util.List;

import com.example.demo.model.UserModel;

public interface UserBusinessInterface {
    public List<UserModel> getUser();

    public boolean addUser(UserModel userModel);

    public UserModel getUserById(int id);

    public boolean deleteUser(UserModel userModel);

    public boolean updateUser(UserModel userModel);
}
