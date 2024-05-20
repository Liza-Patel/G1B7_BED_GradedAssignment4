package com.greatlearning.EmployeeManagementWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeManagementWebApp.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
