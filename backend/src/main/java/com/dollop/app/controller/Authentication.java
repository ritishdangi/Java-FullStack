package com.dollop.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.dto.UserDto;
import com.dollop.app.model.Role;
import com.dollop.app.model.User;
import com.dollop.app.serviceImpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class Authentication {
	@Autowired
	private UserServiceImpl service;

	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto user) {
		return new ResponseEntity<UserDto>(service.register(user), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto loginUser, HttpSession session) {
		User user = service.login(loginUser.getEmail(), loginUser.getPassword());
//		if(user != null) {
		session.setAttribute("user", user);
//		}
//		return ResponseEntity.ok("Login successful");
//		Map<String, String> response = new HashMap<>();
//		response.put("message", "Login successful");
//		response.put("role", user.getRole().name());
//
//		return ResponseEntity.ok(response);
		 Map<String, Object> response = new HashMap<>();
		    response.put("id", user.getId());
		    response.put("email", user.getEmail());
		    response.put("role", user.getRole());
		    response.put("name", user.getName());
		    return ResponseEntity.ok(response);
	}
	@GetMapping("/get")
	public ResponseEntity<List<UserDto>> getAll(@RequestParam("userId") Integer userId){
		User us = service.getUserById(userId);

	    if (us.getRole().equals(Role.ADMIN)) {
	        return ResponseEntity.ok(service.getAllUsers());
	    }

	    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
	    return new ResponseEntity<User>(service.getUserById(id),HttpStatus.OK);
	}
	@GetMapping("/getCsr")
	public ResponseEntity<List<User>> getCsr(){
		List<User> all = service.getAllUserCsr();
		return new ResponseEntity<List<User>>(all,HttpStatus.OK);
	}
}
