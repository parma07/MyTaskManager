package com.cts.taskmanagerservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.taskmanagerservice.model.Responce;
import com.cts.taskmanagerservice.model.User;
import com.cts.taskmanagerservice.service.UserService;

@RestController
@RequestMapping("/api/taskmanager/user")
public class UserController {
	
	Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/saveUser", method= RequestMethod.POST)
	public Responce<String> addUser(@RequestBody User user){
		LOGGER.info("Inside saveUser:", user.getEmployeeId());
		Responce<String> responce;
		try{
			user=userService.saveUser(user);
			responce = new Responce<String>(user.getUserId().toString(), "SUCCESS", "200");
		}catch(Exception e){
			e.printStackTrace();
			responce = new Responce<String>(null, "FAIL", "000");
		}		
		return responce;		
	}
	
	@RequestMapping(path="/getUsers", method= RequestMethod.POST)
	public Responce<List<User>> getUsers(){
		LOGGER.info("Inside getUser:");
		Responce<List<User>> responce;
		List<User> users = new ArrayList<User>();
		
		try{
			users=userService.getUsers();
			responce = new Responce<List<User>>(users, "SUCCESS", "200");
		}catch(Exception e){
			e.printStackTrace();
			responce = new Responce<List<User>>(null, "FAIL", "000");
		}		
		return responce;		
	}
	
	
}
