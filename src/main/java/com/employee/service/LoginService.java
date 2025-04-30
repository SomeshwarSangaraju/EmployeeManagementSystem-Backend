package com.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Login;
import com.employee.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public List<Login> userDetails() {
		return loginRepository.findAll();
	}
	
	public Login userDetailsById(Long id) {
		return loginRepository.findById(id).orElse(null);
	}

	public Login signUpUser(Login login) {
		return loginRepository.save(login);
	}
	

}
