package com.example.demo.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.data.ProductDataService;
import com.example.demo.data.entity.ProductEntity;
import com.example.demo.model.ProductModel;

public class ProductBusinessService implements ProductBusinessInterface{

    Logger logger = LogManager.getLogger(ProductBusinessService.class);

    @Autowired
    private ProductDataService service;

    @Override
    public List<ProductModel> getProduct() {
        logger.info("INFO: entering getProduct method...");

        logger.info("Info: retrieving product data using ProductDataService...");
        List<ProductEntity> productEntity = service.findAll();

        List<ProductModel> productDomain = new ArrayList<ProductModel>();

        for (ProductEntity entity : productEntity)
        {
            productDomain.add(new ProductModel(entity.getId(), entity.getName(), entity.getCost(), entity.getDescription()));
        }

        logger.info("INFO: exiting getProductMethod...");
        return productDomain;
    }

    @Override
    public boolean addProduct(ProductModel productModel) {
        logger.info("INFO: entering addProduct method...");
        logger.info("INFO: adding new ProductEntity to database using ProductDataService");
        logger.info("New ProductEntity: \nName: " + productModel.getName() + ",\nCost: " + productModel.getCost() + ",\nDescription: " + productModel.getDescription());
        ProductEntity entity = new ProductEntity(null, productModel.getName(), productModel.getCost(), productModel.getDescription());
        logger.info("INFO: exiting addProduct method...");
        return service.create(entity);
    }

    @Override
    public ProductModel getProductById(int id) {
        logger.info("INFO: entering getProductById method");
        ProductEntity entity = service.findById(id);
        logger.info("Found ProductEntity: \nName: " + entity.getName() + ",\nCost: " + entity.getCost() + ",\nDescription: " + entity.getDescription());
        logger.info("INFO: exiting getProductById method");
        return new ProductModel(entity.getId(), entity.getName(), entity.getCost(), entity.getDescription());
        
    }

    @Override
    public boolean deleteProduct(ProductModel productModel) {
        logger.info("INFO: entering deleteProduct method");
        ProductEntity entity = new ProductEntity(productModel.getId(), productModel.getName(), productModel.getCost(), productModel.getDescription());
        logger.info("Removing ProductEntity: \nName: " + entity.getName() + ",\nCost: " + entity.getCost() + ",\nDescription: " + entity.getDescription());
        logger.info("INFO: exiting deleteProduct method");
        return service.delete(entity);
    }

    @Override
    public boolean updateProduct(ProductModel productModel) {
        logger.info("INFO: entering updateProduct method");
        ProductEntity entity = new ProductEntity(productModel.getId(), productModel.getName(), productModel.getCost(), productModel.getDescription());
        logger.info("Updating ProductEntity: \nName: " + entity.getName() + ",\nCost: " + entity.getCost() + ",\nDescription: " + entity.getDescription());
        logger.info("INFO: exiting updateProduct method");
        return service.update(entity);
    }
    
}
