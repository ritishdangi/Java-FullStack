package com.dollop.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.dto.EmployeeDto;
import com.dollop.app.dto.LeaveApplicationDto;
import com.dollop.app.dto.LeaveTypeDto;
import com.dollop.app.model.Employee;
import com.dollop.app.model.LeaveApplication;
import com.dollop.app.model.LeaveType;
import com.dollop.app.servicesImpl.EmployeeServiceImpl;
import com.dollop.app.servicesImpl.LeaveApplicationServiceImpl;
import com.dollop.app.servicesImpl.LeaveTypeServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class AppController {
	@Autowired
	private LeaveApplicationServiceImpl lApplication;
	@Autowired
	private EmployeeServiceImpl eService;
	@Autowired
	private LeaveTypeServiceImpl lService;

	// -------- Employee API ---------//

	@PostMapping("/employees")
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());

			return ResponseEntity.badRequest().body(errors);
		}
		eService.createEmployee(employeeDto);
		return ResponseEntity.ok("Employee created successfully");
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> update(@Valid @PathVariable Integer id, @Valid @RequestBody EmployeeDto employe) {
		return new ResponseEntity<Employee>(eService.updateEmployee(id, employe), HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		Optional<Employee> employee = eService.getEmployeeById(id);
		return ResponseEntity.ok(employee.get());
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> all = eService.getAllEmployee();
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		eService.deleteEmployee(id);
		return ResponseEntity.ok("Employee deleted successfully with ID: " + id);

	}
	// -------- Leave-Application API -------//

	@PostMapping("/leaves")
	public ResponseEntity<?> applyLeave(@Valid @RequestBody LeaveApplicationDto dto, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());

			return ResponseEntity.badRequest().body(errors);
		}
		return new ResponseEntity<LeaveApplication>(lApplication.applyLeave(dto), HttpStatus.CREATED);
	}

	@GetMapping("/leaves")
	public ResponseEntity<List<LeaveApplication>> getAllApplications() {
		List<LeaveApplication> all = lApplication.getAllLeaveApplications();
		return new ResponseEntity<>(all, HttpStatus.OK);
	}

	@GetMapping("/leaves/{id}")
	public ResponseEntity<LeaveApplication> getApplicationById(@PathVariable Integer id) {
		Optional<LeaveApplication> lAp = lApplication.getLeaveApplicationById(id);
		return ResponseEntity.ok(lAp.get());
	}

	@PutMapping("/leaves/approve/{id}")
	public ResponseEntity<LeaveApplication> approveLeave(@PathVariable Integer id) {

		return new ResponseEntity<LeaveApplication>(lApplication.rejectApplication(id), HttpStatus.OK);
	}

	@PutMapping("/leaves/reject/{id}")
	public ResponseEntity<LeaveApplication> rejectLeave(@PathVariable Integer id) {
		return new ResponseEntity<LeaveApplication>(lApplication.rejectApplication(id),HttpStatus.OK);
	}

	// -------- Leave-Type API ---------//
	@PostMapping("/leave-type")
	public ResponseEntity<?> createLeave(@Valid @RequestBody LeaveTypeDto ldto, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());

			return ResponseEntity.badRequest().body(errors);
		}
		return new ResponseEntity<LeaveType>(lService.createLeaveType(ldto), HttpStatus.CREATED);
	}

	@GetMapping("/leave-type")
	public ResponseEntity<List<LeaveType>> getAllLeaveType() {
		List<LeaveType> all = lService.getAllLeaveTypes();
		return new ResponseEntity<>(all, HttpStatus.OK);
	}
}
