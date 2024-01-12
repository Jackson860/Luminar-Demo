package com.javaspringbook.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringbook.springboot.model.UserDetails;
import com.javaspringbook.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails createUser(UserDetails user) {
		
		return userRepo.save(user);
	}
	
	

}
