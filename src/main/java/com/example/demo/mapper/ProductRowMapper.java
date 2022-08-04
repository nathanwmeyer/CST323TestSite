package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.data.entity.ProductEntity;

public class ProductRowMapper implements RowMapper<ProductEntity>{
    Logger logger = LogManager.getLogger(ProductRowMapper.class);

    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        logger.info("INFO: entering mapRow method");
        logger.info("INFO: exiting mapRow method");
        return new ProductEntity(rs.getLong("ID"), rs.getString("NAME"), rs.getFloat("COST"), rs.getString("DESCRIPTION"));
        
    }
    
}
