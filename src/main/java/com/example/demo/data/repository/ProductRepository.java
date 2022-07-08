package com.example.demo.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.data.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long>  {
    
}
