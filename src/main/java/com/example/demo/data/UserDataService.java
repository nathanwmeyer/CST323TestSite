package com.example.demo.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.data.entity.UserEntity;
import com.example.demo.data.repository.UserRepository;

@Service
public class UserDataService implements DataAccessInterface<UserEntity>{

    @Autowired
    private UserRepository userRepository;

    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public UserDataService(UserRepository userRepository, DataSource dataSource)
    {
        this.userRepository = userRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> user = new ArrayList<UserEntity>();

        try
        {
            Iterable<UserEntity> userIterable = userRepository.findAll();

            userIterable.forEach(user::add);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean create(UserEntity user) {
        String sql = "INSERT INTO USERS(USERNAME, EMAIL) VALUES(?, ?)";
        try
        {
            jdbcTemplateObject.update(sql, user.getUserName(), user.getEmail());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(UserEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(UserEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public UserEntity findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
