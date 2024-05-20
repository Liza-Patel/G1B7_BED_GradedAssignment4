package com.greatlearning.EmployeeManagementWebApp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementWebApp.entity.Employee;
import com.greatlearning.EmployeeManagementWebApp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/greet")
	public String greet(Principal user) {
		return "Welcome " + user.getName();
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp) {
		return employeeService.addEmployee(emp);
	}

	@GetMapping("/getEmployees")
	public List<Employee> getallemployees() {
		return employeeService.getallemployees();
	}

	@GetMapping("/getEmployeeById/{empId}")
	public Employee getEmployeeById(@PathVariable("empId") int empId) {
		return employeeService.getEmployeeById(empId);
	}

	@PutMapping("/updateEmployee/{empId}")
	Employee updateEmployee(@PathVariable("empId") int empId, @RequestBody Employee newEmp) {
		return employeeService.updateEmployee(empId, newEmp);
	}

	@DeleteMapping("/deleteEmployeeById/{empId}")
	String deleteEmployeeById(@PathVariable("empId") int empId) {
		employeeService.deleteById(empId);
		return "Deleted employee id - " + empId;
	}

	@GetMapping("/getEmployeeByFirstName/{empName}")
	List<Employee> getEmployeeByFirstName(@PathVariable("empName") String firstName) {
		return employeeService.getEmployeeByFirstName(firstName);
	}

	@GetMapping("/getSortedEmployees/{direction}")
	List<Employee> getSortedEmployees(@PathVariable("direction") Direction direction) {
		return employeeService.getSortedEmployees(direction);
	}

	@RequestMapping("/unauthorized")
	public String unauthorized(Principal user) {

		return "Hello " + user.getName() + ", You do not have access to this page !";

	}

}
