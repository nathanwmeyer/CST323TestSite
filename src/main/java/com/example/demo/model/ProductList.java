package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name="products")
public class ProductList {
    
	//List to hold all products
	private List<ProductModel> products = new ArrayList<ProductModel>(); 
	
	// Getter for list of products
	public List<ProductModel> getProducts(){
		return this.products;
	}
	
	// Setter for list of products
	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}
	
	// Return size of product list
	public int getProductsSize() 
	{
		return products.size();
	}
}
