package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Login;
import com.employee.model.Users;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Login findByUsername(String username);

}
