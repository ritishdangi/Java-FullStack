package com.dollop.app.services;

import java.util.List;
import java.util.Optional;

import com.dollop.app.dto.EmployeeDto;
import com.dollop.app.model.Employee;

public interface IEmployeeService {
	Object createEmployee(EmployeeDto employe);
	Optional<Employee> getEmployeeById(Integer id);
	Employee updateEmployee(Integer id,EmployeeDto employee);
	List<Employee> getAllEmployee();
	void deleteEmployee(Integer id);

}
