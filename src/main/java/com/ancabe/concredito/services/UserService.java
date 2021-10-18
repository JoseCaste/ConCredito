package com.ancabe.concredito.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ancabe.concredito.models.User;
import com.ancabe.concredito.repositories.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	public User findUserByEmail(String email) {
		return userRepository.findByusername(email);
	}
	

}
