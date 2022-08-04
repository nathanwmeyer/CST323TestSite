package com.example.demo.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.business.ProductBusinessInterface;
import com.example.demo.business.UserBusinessInterface;
import com.example.demo.model.ProductModel;
import com.example.demo.model.UserModel;

@Controller
public class MainController {

    Logger logger = LogManager.getLogger(MainController.class);

    @Autowired
    ProductBusinessInterface productService;

    @Autowired
    UserBusinessInterface userService;

    @GetMapping("/")
    public String accessHome(Model model)
    {
        logger.info("INFO: entering accessHome method...");
        model.addAttribute("title", "Home");
        model.addAttribute("userModel", new UserModel());
        
        logger.info("INFO: exiting accessHome method...");
        return "index";
    }

    @RequestMapping("/test1")
    public String startTest1(Model model)
    {
        logger.info("INFO: entering startTest1 method...");
        model.addAttribute("title", "Test 1");
		model.addAttribute("products", productService.getProduct());
        model.addAttribute("productModel", new ProductModel());

        logger.info("INFO: exiting startTest1 method...");
        return "test1";
    }

    @RequestMapping("/test2")
    public String startTest2(Model model)
    {
        logger.info("INFO: entering startTest2 method...");
        model.addAttribute("title", "Test 2");        
        model.addAttribute("userModel", new UserModel());
        model.addAttribute("users", userService.getUser());

        logger.info("INFO: exiting startTest2 method...");
        return "test2";
    }

    @RequestMapping("/test3")
    public String startTest3(Model model)
    {
        logger.info("INFO: entering startTest3 method...");
        model.addAttribute("title", "Test 3");
        model.addAttribute("userModel", new UserModel());
		model.addAttribute("products", productService.getProduct());
        model.addAttribute("users", userService.getUser());

        logger.info("INFO: exiting startTest3 method...");
        return "test3";
    }
    
    @PostMapping("/doAddProduct")
    public String doAddProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
    {
        logger.info("INFO: entering doAddProduct method...");
        logger.warn("WARNING: errors may occur");
        if (bindingResult.hasErrors()) {
            logger.error("ERROR: bindingResult has errors or improperly formatted data!");
            return "test2";
        }

        logger.info("INFO: Adding new productModel to database: \n Name" + productModel.getName() + ",\n Cost: " + productModel.getCost() + ",\n Description: " + productModel.getDescription());

        productService.addProduct(productModel);
        
		model.addAttribute("products", productService.getProduct());
        logger.info("INFO: exiting doAddProduct method...");
        return "test1";
    }

    @PostMapping("/doAddUser")
    public String doAddUser(@Valid UserModel userModel, BindingResult bindingResult, Model model)
    {
        logger.info("INFO: entering doAddUser method...");
        if (bindingResult.hasErrors()) {
            logger.error("ERROR: bindingResult has errors or improperly formatted data!");
            return "test1";
        }

        logger.info("INFO: Adding new userModel to database:\n Username "+ userModel.getUserName() + 
        ",\n Email: " + userModel.getEmail());

        userService.addUser(userModel);
        
        model.addAttribute("users", userService.getUser());
        logger.info("INFO: exiting doAddUser method...");
        return "test2";
    }
}
