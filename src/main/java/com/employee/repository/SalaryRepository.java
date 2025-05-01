package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long>{

}
