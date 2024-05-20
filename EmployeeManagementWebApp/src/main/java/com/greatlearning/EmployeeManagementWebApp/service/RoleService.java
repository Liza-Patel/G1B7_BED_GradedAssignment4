package com.greatlearning.EmployeeManagementWebApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementWebApp.entity.Role;
import com.greatlearning.EmployeeManagementWebApp.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepo;

	public Role addRole(Role role) {

		return roleRepo.save(role);
	}

}
