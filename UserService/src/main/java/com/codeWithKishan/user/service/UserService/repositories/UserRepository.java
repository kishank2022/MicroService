package com.codeWithKishan.user.service.UserService.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithKishan.user.service.UserService.entities.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByEmail(String email);
	
}
