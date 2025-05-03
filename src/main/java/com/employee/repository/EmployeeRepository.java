package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Employee;
import com.employee.model.Users;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	Employee findByUsername(String username);

}
