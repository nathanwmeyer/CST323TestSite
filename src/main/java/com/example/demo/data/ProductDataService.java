package com.example.demo.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.data.entity.ProductEntity;
import com.example.demo.data.repository.ProductRepository;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity>{

    Logger logger = LogManager.getLogger(ProductDataService.class);

    @Autowired
    private ProductRepository productRepository;

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public ProductDataService(ProductRepository productRepository, DataSource dataSource)
    {
        this.productRepository = productRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    @Override
    public List<ProductEntity> findAll() {
        logger.info("INFO: Entering findAll() method");
        List<ProductEntity> product = new ArrayList<ProductEntity>();

        try
        {
            logger.info("INFO: retrieving data from productRepository");
            Iterable<ProductEntity> productIterable = productRepository.findAll();

            productIterable.forEach(product::add);
        }
        catch (Exception e)
        {
            logger.error("ERROR: error while attempting to retrieve data from productRepository");
            e.printStackTrace();
        }
        logger.info("INFO: exiting findAll() method");
        return product;
    }

    @Override
    public ProductEntity findById(int id) {
        logger.error("ERROR: this method (findById) has not been implemented and should not appear during normal use");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean create(ProductEntity product) {
        logger.info("INFO: entering create method");
        String sql = "INSERT INTO PRODUCTS(NAME, COST, DESCRIPTION) VALUES(?, ?, ?)";
        try
        {
            logger.info("INFO: updating information with new information");
            jdbcTemplateObject.update(sql, product.getName(), product.getCost(), product.getDescription());
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
    public boolean update(ProductEntity t) {
        logger.error("ERROR: this method (findById) has not been implemented and should not appear during normal use");
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ProductEntity t) {
        logger.error("ERROR: this method (findById) has not been implemented and should not appear during normal use");
        // TODO Auto-generated method stub
        return false;
    }
    
}
