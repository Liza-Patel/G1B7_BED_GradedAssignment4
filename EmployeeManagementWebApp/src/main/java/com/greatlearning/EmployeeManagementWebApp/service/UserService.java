package com.greatlearning.EmployeeManagementWebApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementWebApp.entity.User;
import com.greatlearning.EmployeeManagementWebApp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public User addUser(User user) {

		return userRepo.save(user);
	}

}
