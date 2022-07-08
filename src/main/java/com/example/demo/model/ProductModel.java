package com.example.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class ProductModel {
    @Size(min=1, max=32, message="Between 1 & 32")
	@NotNull(message="This is a required field")
	private String name;

	private float cost;

	private String description;

	//@Id
	private long id;
	
	public ProductModel () {}	
	
	public ProductModel(Long id, String name, float cost, String description) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
