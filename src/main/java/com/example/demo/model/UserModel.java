package com.example.demo.model;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;

public class UserModel {
    //@Id
	private long id;

	@Email(message = "Valid email is required")
	private String email;

	@Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
	private String userName;

	public UserModel() {
	}

	public UserModel(Long id, String email, String userName) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
