package com.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Login;
import com.employee.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	 @PostMapping("/register")
	    public Login register(@RequestBody Login user) {
	        return loginService.register(user);

	    }

	    @PostMapping("/login")
	    public String login(@RequestBody Login user) {
	        return loginService.verify(user);
	    }
	    
	    
//	    @GetMapping
//		public ResponseEntity<List<Login>> userLogin(){
//			return new ResponseEntity<>(loginService.userDetails(),HttpStatus.OK);
//		}
	//	
//		@GetMapping("/{id}")
//		public ResponseEntity<Login> userLoginById(@PathVariable Long id) {
//			return new ResponseEntity<>(loginService.userDetailsById(id),HttpStatus.ACCEPTED);	
//		}
	//	
//		@PostMapping
//		public ResponseEntity<Login> newUser(@RequestBody Login login){
//			return new ResponseEntity<>(loginService.signUpUser(login),HttpStatus.CREATED);
//		}

}
