package com.codeWithKishan.user.service.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeWithKishan.user.service.UserService.entities.User;
import com.codeWithKishan.user.service.UserService.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	// create user 
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user ){
		User user1 = this.userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	// get Single user 
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		User user = this.userService.getUser(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// get all users 
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> list1 = this.userService.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(list1);
	}
	
	// update user details 
	@PutMapping("/")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updatedUser = this.userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		String result = this.userService.deleteUser(userId);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
