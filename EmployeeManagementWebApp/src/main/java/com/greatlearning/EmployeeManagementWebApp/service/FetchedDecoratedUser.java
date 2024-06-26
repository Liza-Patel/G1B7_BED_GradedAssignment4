package com.greatlearning.EmployeeManagementWebApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementWebApp.entity.User;
import com.greatlearning.EmployeeManagementWebApp.repository.UserRepository;

@Service
public class FetchedDecoratedUser implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User not found");
		return new UserDecorator(user);
	}

}
