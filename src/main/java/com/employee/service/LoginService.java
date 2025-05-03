package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.model.Login;
import com.employee.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private LoginRepository repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Login register(Login user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public String verify(Login user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "fail";
        }
    }
}
