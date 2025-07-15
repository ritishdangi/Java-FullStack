package com.dollop.app.mapper;

import org.springframework.stereotype.Component;

import com.dollop.app.dto.EmployeeDto;
import com.dollop.app.model.Employee;

@Component
public class EmployeeMapper {
	 public Employee toEntity(EmployeeDto dto) {
	        if (dto == null) {
	            return null;
	        }
	        Employee employee = new Employee();
	        employee.setEmpId(dto.getEmpId());
	        employee.setEmpName(dto.getEmpName());
	        employee.setEmpEmail(dto.getEmpEmail());
	        employee.setEmpDept(dto.getEmpDept());
	        employee.setEmpJoining(dto.getEmpJoining());
	        return employee;
	    }
}
