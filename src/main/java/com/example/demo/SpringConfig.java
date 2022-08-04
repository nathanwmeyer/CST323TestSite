package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.business.ProductBusinessInterface;
import com.example.demo.business.ProductBusinessService;
import com.example.demo.business.UserBusinessInterface;
import com.example.demo.business.UserBusinessService;

@Configuration
public class SpringConfig {
    Logger logger = LogManager.getLogger(SpringConfig.class);

    @Bean(name= "userBusinessService")
    public UserBusinessInterface getUserBusiness()
    {
        logger.info("INFO: entering getUserBusiness");
        logger.info("INFO: exiting getUserBusiness");
        return new UserBusinessService();
    }

    @Bean(name= "productBusinessService")
    public ProductBusinessInterface getProductBusiness()
    {
        logger.info("INFO: entering getProductBusiness");
        logger.info("INFO: exiting getProductBusiness");
        return new ProductBusinessService();
    }
}
