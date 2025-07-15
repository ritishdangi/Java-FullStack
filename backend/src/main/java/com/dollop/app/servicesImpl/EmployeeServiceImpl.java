package com.dollop.app.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.dto.EmployeeDto;
import com.dollop.app.exception.EmployeeNotFound;
import com.dollop.app.mapper.EmployeeMapper;
import com.dollop.app.model.Employee;
import com.dollop.app.repository.IEmployeeRepo;
import com.dollop.app.repository.ILeaveApplicatioRepo;
import com.dollop.app.services.IEmployeeService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private IEmployeeRepo eRepo;
	@Autowired
	private EmployeeMapper eMapper;
	@Autowired
	private ILeaveApplicatioRepo lREpo;

	@Override
	public Employee createEmployee(EmployeeDto employe) {
		Optional<Employee> emp = eRepo.findByEmpEmail(employe.getEmpEmail());
		if(emp.isPresent()) {
			throw new EmployeeNotFound("Email Already Exist");
		}
		
		Employee empl = eMapper.toEntity(employe); 
		return eRepo.save(empl);
	}

	@Override
	public Employee updateEmployee(Integer id, EmployeeDto employee) {
		if(eRepo.existsById(id)) {
			Optional<Employee> emp = eRepo.findByEmpEmail(employee.getEmpEmail());
			
			if(emp.isPresent()) {
				throw new EmployeeNotFound("Email is already exist");
			}
			employee.setEmpId(id);
			return eRepo.save(eMapper.toEntity(employee));
		}
		else {
			throw new EmployeeNotFound("Employee Not Found With ID: ");
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		return eRepo.findAll();
	}

	@Override
	public void deleteEmployee(Integer id) {
		Optional<Employee> empl = eRepo.findById(id);
		if(!empl.isPresent()) {
			throw new EmployeeNotFound("Employee Not Found: "+id);
		}
		lREpo.deleteByEmployeeId(id);
		eRepo.deleteById(id);
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		Optional<Employee> empl = eRepo.findById(id);
		if(!empl.isPresent()) {
			throw new EmployeeNotFound("Employee Not Found: "+id);
		}
		return eRepo.findById(id);
	}

}

