package com.greatlearning.EmployeeManagementWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementWebApp.entity.Employee;
import com.greatlearning.EmployeeManagementWebApp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	public Employee addEmployee(Employee emp) {

		return empRepo.save(emp);
	}

	public List<Employee> getallemployees() {

		return empRepo.findAll();
	}

	public Employee getEmployeeById(int empId) {

		return empRepo.findById(empId).get();
	}

	public Employee updateEmployee(int empId, Employee newEmp) {
		Employee oldEmp = empRepo.findById(empId).get();
		oldEmp.setFirstName(newEmp.getFirstName());
		oldEmp.setLastName(newEmp.getLastName());
		oldEmp.setEmail(newEmp.getEmail());
		return empRepo.save(oldEmp);
	}

	public void deleteById(int empId) {

		empRepo.deleteById(empId);
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {

		return empRepo.findByFirstName(firstName);
	}

	public List<Employee> getSortedEmployees(Direction direction) {
		return empRepo.findAll(Sort.by(direction, "firstName"));
	}

}
