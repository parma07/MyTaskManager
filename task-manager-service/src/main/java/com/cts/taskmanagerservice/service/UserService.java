package com.cts.taskmanagerservice.service;

import java.util.List;

import com.cts.taskmanagerservice.model.User;

public interface UserService {
	public User saveUser(User user);
	public List<User> getUsers();
}
