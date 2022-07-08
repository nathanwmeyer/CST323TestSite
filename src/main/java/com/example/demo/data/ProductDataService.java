package com.example.demo.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.data.entity.ProductEntity;
import com.example.demo.data.repository.ProductRepository;

@Service
public class ProductDataService implements DataAccessInterface<ProductEntity>{

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
        List<ProductEntity> product = new ArrayList<ProductEntity>();

        try
        {
            Iterable<ProductEntity> productIterable = productRepository.findAll();

            productIterable.forEach(product::add);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public ProductEntity findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean create(ProductEntity product) {
        String sql = "INSERT INTO PRODUCTS(NAME, COST, DESCRIPTION) VALUES(?, ?, ?)";
        try
        {
            jdbcTemplateObject.update(sql, product.getName(), product.getCost(), product.getDescription());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(ProductEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ProductEntity t) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
