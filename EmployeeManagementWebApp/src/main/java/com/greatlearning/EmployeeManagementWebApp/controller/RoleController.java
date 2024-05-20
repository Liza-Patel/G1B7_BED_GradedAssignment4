package com.greatlearning.EmployeeManagementWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementWebApp.entity.Role;
import com.greatlearning.EmployeeManagementWebApp.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	RoleService roleService;

	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}

}
