package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name="users")
public class UserList {
    //List to hold all users
	private List<UserModel> users = new ArrayList<UserModel>(); 
	
	// Getter for list of users
	public List<UserModel> getUsers(){
		return this.users;
	}
	
	// Setter for list of users
	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
	
	// Return size of user list
	public int getUsersSize() 
	{
		return users.size();
	}
}
