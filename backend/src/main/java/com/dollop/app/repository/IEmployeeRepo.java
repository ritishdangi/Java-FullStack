package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
	Optional<Employee> findByEmpEmail(String empEmail);
}
