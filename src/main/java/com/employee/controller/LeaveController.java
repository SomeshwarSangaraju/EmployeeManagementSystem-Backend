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

import com.employee.model.Leave;
import com.employee.service.LeaveService;

@RestController
@RequestMapping("/leave")
public class LeaveController {
	
	@Autowired
	private LeaveService leaveService;
	
	
	@GetMapping
	public ResponseEntity<List<Leave>> getAllEmployeesLeaveDetails(){
		return new ResponseEntity<>(leaveService.employeeLeaves(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Leave> employeeLeavesById(@PathVariable Long id){
		return new ResponseEntity<>(leaveService.employeeLeaveById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Leave> employeeApplyingLeave(@RequestBody Leave leave){
		return new ResponseEntity<>(leaveService.employeeApplyingLeaves(leave),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
		leaveService.deleteLeave(id);
		return new ResponseEntity<String>("Employee deleted Successfully",HttpStatus.OK);
	}

}
