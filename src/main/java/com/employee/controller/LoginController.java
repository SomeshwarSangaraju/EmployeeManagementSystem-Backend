package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Login;
import com.employee.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping
	public ResponseEntity<List<Login>> userLogin(){
		return new ResponseEntity<>(loginService.userDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Login> userLoginById(@PathVariable Long id) {
		return new ResponseEntity<>(loginService.userDetailsById(id),HttpStatus.ACCEPTED);	
	}
	
	@PostMapping
	public ResponseEntity<Login> newUser(@RequestBody Login login){
		return new ResponseEntity<>(loginService.signUpUser(login),HttpStatus.CREATED);
	}

}
