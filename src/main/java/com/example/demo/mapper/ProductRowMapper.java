package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.data.entity.ProductEntity;

public class ProductRowMapper implements RowMapper<ProductEntity>{

    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductEntity(rs.getLong("ID"), rs.getString("NAME"), rs.getFloat("COST"), rs.getString("DESCRIPTION"));
    }
    
}
