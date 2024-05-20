package com.greatlearning.EmployeeManagementWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementWebApp.entity.User;
import com.greatlearning.EmployeeManagementWebApp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

}
