package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.UserNotFoundException;
import com.employee.model.Salary;
import com.employee.repository.SalaryRepository;

@Service
public class SalaryService {
	
	@Autowired
	private SalaryRepository salaryRepository;

	public List<Salary> employeesSalary() {
		return salaryRepository.findAll();
	}
	
	public Salary employeesById(Long id) {
		return salaryRepository.findById(id).orElseThrow(()->new UserNotFoundException("EmployeeSalary with ID " + id + " not found"));
	}
	
	public Salary addSalary(Salary salary) {
		return salaryRepository.save(salary);
	}
	
	public void deleteSalary(Long id) {
		salaryRepository.deleteById(id);
	}

}
