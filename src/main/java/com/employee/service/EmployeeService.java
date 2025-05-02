package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.UserNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> employeeDetails(){
		return employeeRepository.findAll();
	}
	
	public Employee employeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(()->new UserNotFoundException("Employee with ID " + id + " not found"));
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee editEmployeeDetails(Long id,Employee employee) {
		Employee emp = new Employee();
		emp.setDepartment(employee.getDepartment());
		emp.setEmail(employee.getEmail());
		emp.setName(employee.getName());
		emp.setPhoneNo(employee.getPhoneNo());
		return employeeRepository.save(emp);
	}

}
