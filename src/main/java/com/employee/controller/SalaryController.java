package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Salary;
import com.employee.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	

	@GetMapping
	public ResponseEntity<List<Salary>> getAllEmployeeSalary(){
		return new ResponseEntity<>(salaryService.employeesSalary(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Salary> getAllEmployeeSalaryById(@PathVariable Long id){
		return new ResponseEntity<>(salaryService.employeesById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Salary> addEmployeeSalary(@RequestBody Salary salary){
		return new ResponseEntity<>(salaryService.addSalary(salary),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeSalary(@PathVariable Long id){
		salaryService.deleteSalary(id);
		return new ResponseEntity<>("Deleted Employee salary successfully",HttpStatus.ACCEPTED);
	}
	
}
