package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.data.entity.UserEntity;

public class UserRowMapper implements RowMapper<UserEntity>{
    Logger logger = LogManager.getLogger(UserRowMapper.class);

    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        logger.info("INFO: entering mapRow method");
        logger.info("INFO: exiting mapRow method");
        return new UserEntity(rs.getLong("ID"), rs.getString("USERNAME"), rs.getString("EMAIL"));
    }
    
}
