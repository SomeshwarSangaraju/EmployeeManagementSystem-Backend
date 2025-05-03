package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.model.Login;
import com.employee.model.UserPrinciple;
import com.employee.repository.LoginRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        
        return new UserPrinciple(user);
    }
}
