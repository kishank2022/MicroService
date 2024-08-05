package com.codeWithKishan.user.service.UserService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWithKishan.user.service.UserService.entities.User;
import com.codeWithKishan.user.service.UserService.exceptions.ResourceNotFoundException;
import com.codeWithKishan.user.service.UserService.repositories.UserRepository;
import com.codeWithKishan.user.service.UserService.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		User savedUser = this.userRepository.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUser() {
		List<User> allUsers = this.userRepository.findAll();
		return allUsers;
	}

	@Override
	public User getUser(String userId) {
		Long user_id = Long.valueOf(userId);
		User user = new User();
		Optional<User> optionalUser = this.userRepository.findById(user_id);
		if(optionalUser.isPresent()) {
			user = optionalUser.get();
		}else {
			throw new ResourceNotFoundException("user with id "+ userId + " is not found !!");
		}
		return user;
	}

	@Override
	public User updateUser(User user) {
		User updatedUser = new User();
		Optional<User> optionalUser = this.userRepository.findById(user.getUserId());
//		Optional<User> optionalUser = this.userRepository.findByEmail(user.getEmail());
		if(optionalUser.isPresent()) {
			updatedUser = this.userRepository.save(user);			
		}
		return updatedUser;
	}

	@Override
	public String deleteUser(String userId) {
//		Optional<User> optionalUser = this.userRepository.findById(userId);
//		if(optionalUser.isPresent()) {
////			User deleteUSer = optionalUser;
//			this.userRepository.delete(optionalUser.get());		
//			return "User Deleted Successfully !!!";
//		}
		Long user_id = Long.valueOf(userId);
		User user = this.userRepository.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("user with this id is not found!!:"+userId));
		if(user!=null) {
			this.userRepository.deleteById(user_id);
			return "User Deleted Successfully !!!";
		}
		
		return "User with this ID is not present!!";

	}

}
