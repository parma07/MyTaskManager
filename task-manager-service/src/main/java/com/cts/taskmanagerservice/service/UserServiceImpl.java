package com.cts.taskmanagerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.taskmanagerservice.model.User;
import com.cts.taskmanagerservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {		
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {		
		return userRepository.findAll();
	}
	
}
