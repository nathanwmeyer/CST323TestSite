package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.data.entity.UserEntity;

public class UserRowMapper implements RowMapper<UserEntity>{

    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserEntity(rs.getLong("ID"), rs.getString("USERNAME"), rs.getString("EMAIL"));
    }
    
}
