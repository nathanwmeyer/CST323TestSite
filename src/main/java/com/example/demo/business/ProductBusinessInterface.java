package com.example.demo.business;

import java.util.List;

import com.example.demo.model.ProductModel;

public interface ProductBusinessInterface {
    public List<ProductModel> getProduct();

    public boolean addProduct(ProductModel productModel);

    public ProductModel getProductById(int id);

    public boolean deleteProduct(ProductModel productModel);

    public boolean updateProduct(ProductModel productModel);
}
