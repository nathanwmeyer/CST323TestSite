package com.example.demo.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.data.ProductDataService;
import com.example.demo.data.entity.ProductEntity;
import com.example.demo.model.ProductModel;

public class ProductBusinessService implements ProductBusinessInterface{

    @Autowired
    private ProductDataService service;

    @Override
    public List<ProductModel> getProduct() {
        List<ProductEntity> productEntity = service.findAll();

        List<ProductModel> productDomain = new ArrayList<ProductModel>();

        for (ProductEntity entity : productEntity)
        {
            productDomain.add(new ProductModel(entity.getId(), entity.getName(), entity.getCost(), entity.getDescription()));
        }

        return productDomain;
    }

    @Override
    public boolean addProduct(ProductModel productModel) {
        ProductEntity entity = new ProductEntity(null, productModel.getName(), productModel.getCost(), productModel.getDescription());
        return service.create(entity);
    }

    @Override
    public ProductModel getProductById(int id) {
        ProductEntity entity = service.findById(id);
        return new ProductModel(entity.getId(), entity.getName(), entity.getCost(), entity.getDescription());
    }

    @Override
    public boolean deleteProduct(ProductModel productModel) {
        ProductEntity entity = new ProductEntity(productModel.getId(), productModel.getName(), productModel.getCost(), productModel.getDescription());
        return service.delete(entity);
    }

    @Override
    public boolean updateProduct(ProductModel productModel) {
        ProductEntity entity = new ProductEntity(productModel.getId(), productModel.getName(), productModel.getCost(), productModel.getDescription());
        return service.update(entity);
    }
    
}
