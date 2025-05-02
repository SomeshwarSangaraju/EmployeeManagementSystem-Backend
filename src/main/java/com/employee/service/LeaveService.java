package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.UserNotFoundException;
import com.employee.model.Leave;
import com.employee.repository.LeaveRepository;

@Service
public class LeaveService {
	
	@Autowired
	private LeaveRepository leaveRepository;
	
	public List<Leave> employeeLeaves(){
		return leaveRepository.findAll();
	}
	
	public Leave employeeLeaveById(Long id) {
		return leaveRepository.findById(id).orElseThrow(()->new UserNotFoundException("Employee with ID " + id + " not found"));
	}
	
	public Leave employeeApplyingLeaves(Leave leave) {
		return leaveRepository.save(leave);
	}
	
	public void deleteLeave(Long id) {
		leaveRepository.deleteById(id);
	}
	

}
