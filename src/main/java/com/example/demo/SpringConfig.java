package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.business.ProductBusinessInterface;
import com.example.demo.business.ProductBusinessService;
import com.example.demo.business.UserBusinessInterface;
import com.example.demo.business.UserBusinessService;

@Configuration
public class SpringConfig {

    @Bean(name= "userBusinessService")
    public UserBusinessInterface getUserBusiness()
    {
        return new UserBusinessService();
    }

    @Bean(name= "productBusinessService")
    public ProductBusinessInterface getProductBusiness()
    {
        return new ProductBusinessService();
    }
}
