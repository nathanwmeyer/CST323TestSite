package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.ProductBusinessInterface;
import com.example.demo.business.UserBusinessInterface;
import com.example.demo.model.ProductModel;
import com.example.demo.model.UserModel;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    ProductBusinessInterface productService;

    @Autowired
    UserBusinessInterface userService;

    @GetMapping("/")
    public String accessHome(Model model)
    {
        model.addAttribute("title", "Home");
        model.addAttribute("userModel", new UserModel());
        
        return "index";
    }

    @RequestMapping("/test1")
    public String startTest1(Model model)
    {
        model.addAttribute("title", "Test 1");
		model.addAttribute("products", productService.getProduct());
        model.addAttribute("productModel", new ProductModel());
        return "test1";
    }

    @RequestMapping("/test2")
    public String startTest2(Model model)
    {
        model.addAttribute("title", "Test 2");        
        model.addAttribute("userModel", new UserModel());
        model.addAttribute("users", userService.getUser());
        return "test2";
    }

    @RequestMapping("/test3")
    public String startTest3(Model model)
    {
        model.addAttribute("title", "Test 3");
        model.addAttribute("userModel", new UserModel());
		model.addAttribute("products", productService.getProduct());
        model.addAttribute("users", userService.getUser());
        return "test3";
    }
    
    @PostMapping("/doAddProduct")
    public String doAddProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors()) {
            return "test2";
        }

        System.out.print("productModel: " + productModel.getName() + ", " + productModel.getCost() + ", " + productModel.getDescription());

        productService.addProduct(productModel);
        
		model.addAttribute("products", productService.getProduct());
        return "test1";
    }

    @PostMapping("/doAddUser")
    public String doAddUser(@Valid UserModel userModel, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors()) {
            return "test1";
        }

        System.out.print("userModel: "+ userModel.getUserName() + 
        ", " + userModel.getEmail());

        userService.addUser(userModel);
        
        model.addAttribute("users", userService.getUser());
        return "test2";
    }
}
