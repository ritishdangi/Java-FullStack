package com.dollop.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.dto.TicketDto;
import com.dollop.app.model.Role;
import com.dollop.app.model.User;
import com.dollop.app.serviceImpl.TicketServiceImpl;
import com.dollop.app.serviceImpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketServiceImpl service;
	@Autowired
	private UserServiceImpl uService;

	@PostMapping("/create")
	public ResponseEntity<TicketDto> create(@Valid @RequestBody TicketDto ticketDto) {
		return new ResponseEntity<TicketDto>(service.createTicket(ticketDto), HttpStatus.CREATED);
	}

	@PutMapping("/update/{ticketId}/status")
	public ResponseEntity<TicketDto> update(@Valid @PathVariable Integer ticketId, @RequestParam String status) {
		TicketDto update = service.updateTicketStatus(ticketId, status);
		return ResponseEntity.ok(update);
	}

	@PostMapping("/assign/{ticketId}/{csrUserId}")
	public ResponseEntity<TicketDto> assignTicket(@PathVariable Integer ticketId, @PathVariable Integer csrUserId,
			@RequestParam Integer adminId, HttpSession session) {

		User admin = uService.getUserById(adminId);

// Check if role is ADMIN
		if (admin.getRole() != Role.ADMIN) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}

		TicketDto dto = service.assignTicket(ticketId, csrUserId);
		return ResponseEntity.ok(dto);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<TicketDto>> getTicketsByUser(@PathVariable Integer userId) {
		List<TicketDto> userTickets = service.getTicketsByUser(userId);
		return ResponseEntity.ok(userTickets);
	}

	@GetMapping("/assigned/{csrId}")
	public ResponseEntity<List<TicketDto>> getAssignedTickets(@PathVariable Integer csrId) {
	    return ResponseEntity.ok(service.getTicketAssignToCsr(csrId));
	}
	@GetMapping("/get")
	public ResponseEntity<List<TicketDto>> getAll(){
		List<TicketDto> all = service.getAllTickets();
		return new ResponseEntity<List<TicketDto>>(all,HttpStatus.OK);
	}
}
