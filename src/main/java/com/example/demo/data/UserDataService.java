package com.example.demo.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.data.entity.UserEntity;
import com.example.demo.data.repository.UserRepository;

@Service
public class UserDataService implements DataAccessInterface<UserEntity>{

    Logger logger = LogManager.getLogger(UserDataService.class);

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
        logger.info("INFO: Entering findAll() method");
        List<UserEntity> user = new ArrayList<UserEntity>();

        try
        {
            logger.info("INFO: retrieving data from userRepository");
            Iterable<UserEntity> userIterable = userRepository.findAll();

            userIterable.forEach(user::add);
        }
        catch (Exception e)
        {
            logger.error("ERROR: error while attempting to retrieve data from userRepository");
            e.printStackTrace();
        }
        logger.info("INFO: exiting findAll() method");
        return user;
    }

    @Override
    public boolean create(UserEntity user) {
        logger.info("INFO: entering create method");
        String sql = "INSERT INTO USERS(USERNAME, EMAIL) VALUES(?, ?)";
        try
        {
            logger.info("INFO: updating information with new information");
            jdbcTemplateObject.update(sql, user.getUserName(), user.getEmail());
        }
        catch (Exception e)
        {
            logger.error("ERROR: invalid information, cannot update database");
            e.printStackTrace();
        }
        logger.info("INFO: exiting create method");
        return true;
    }

    @Override
    public boolean update(UserEntity t) {
        logger.error("ERROR: this method (update) has not been implemented and should not appear during normal use");
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(UserEntity t) {
        logger.error("ERROR: this method (delete) has not been implemented and should not appear during normal use");
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public UserEntity findById(int id) {
        logger.error("ERROR: this method (findById) has not been implemented and should not appear during normal use");
        // TODO Auto-generated method stub
        return null;
    }
    
}
