package com.codeWithKishan.user.service.UserService.service;

import java.util.List;

import com.codeWithKishan.user.service.UserService.entities.User;

public interface UserService {

	// create User
	User saveUser(User user);
	
	// get All users
	List<User> getAllUser();
	
	// get single user
	User getUser(String userId);
	
	// update user 
	User updateUser(User user);
	
	// delete user 
	String deleteUser(String userId);
}
