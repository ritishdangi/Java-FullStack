package com.dollop.app.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.dto.TicketDto;
import com.dollop.app.exception.ResourceNotFound;
import com.dollop.app.model.Role;
import com.dollop.app.model.Status;
import com.dollop.app.model.Ticket;
import com.dollop.app.model.User;
import com.dollop.app.repository.TicketRepository;
import com.dollop.app.repository.UserRepository;
import com.dollop.app.service.TicketService;
@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	private TicketRepository tRepo;
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public TicketDto createTicket(TicketDto ticketDto) {
//		User assignedTo = uRepo.findById(ticketDto.getAssignedToId()).orElseThrow(()-> new ResourceNotFound("Assigned user not found with ID: " + ticketDto.getAssignedToId()));
		User user = uRepo.findById(ticketDto.getUserId())
                .orElseThrow(() -> new ResourceNotFound("Creating user not found with ID: " + ticketDto.getUserId()));
		Ticket ticket = mapper.map(ticketDto, Ticket.class);
//		ticket.setAssignedTo(null);
		ticket.setTitle(ticketDto.getTitle());
		ticket.setDescription(ticketDto.getDescription());
		ticket.setPriority(ticketDto.getPriority());
		ticket.setStatus(ticketDto.getStatus() != null ? ticketDto.getStatus() : Status.PENDING);
		ticket.setUser(user);
		ticket.setCreatedAt(LocalDateTime.now());
		ticket.setUpdatedAt(LocalDateTime.now());
		
		Ticket save = tRepo.save(ticket);
		return mapper.map(save, TicketDto.class);
	}

	@Override
	public List<TicketDto> getAllTickets() {
		List<Ticket> all = tRepo.findAll();
		List<TicketDto> dto = new ArrayList<>();
		for(Ticket tDto : all) {
			TicketDto ticketDto = mapper.map(tDto, TicketDto.class);
			dto.add(ticketDto);
		}
		return dto;
	}


	@Override
	public TicketDto updateTicketStatus(Integer ticketId, String status) {
		Ticket exist = tRepo.findById(ticketId).orElseThrow(()-> new ResourceNotFound("Ticket Not Found"));
		
		Status st = Status.valueOf(status.toUpperCase());
		exist.setStatus(st);
		exist.setUpdatedAt(LocalDateTime.now());
		Ticket update = tRepo.save(exist);
		return mapper.map(update, TicketDto.class);
	}

	@Override
	public TicketDto assignTicket(Integer ticketId, Integer csrUserId) {
		Ticket ticket = tRepo.findById(ticketId).orElseThrow(()-> new ResourceNotFound("Ticket not found"));
		User csr = uRepo.findById(csrUserId).orElseThrow(()-> new ResourceNotFound("CSR not found"));
		if (!csr.getRole().equals(Role.CSR)) {
	        throw new ResourceNotFound("User is not allowed to be assigned. Role must be CSR.");
	    }

		ticket.setAssignedTo(csr);
	    ticket.setUpdatedAt(LocalDateTime.now());
	    Ticket updatedTicket = tRepo.save(ticket);

	    return mapper.map(updatedTicket, TicketDto.class);
	}

	@Override
	public List<TicketDto> getTicketsByUser(Integer userId) {
		List<Ticket> tickets = tRepo.findByUserId(userId);
	    return tickets.stream()
	            .map(ticket -> mapper.map(ticket, TicketDto.class))
	            .collect(Collectors.toList());
	}

	@Override
	public List<TicketDto> getTicketAssignToCsr(Integer csrId) {
		User csr = uRepo.findById(csrId).orElseThrow(()-> new ResourceNotFound("CSR not found"));
		if (csr.getRole() != Role.CSR) {
	        throw new ResourceNotFound("User is not a CSR");
	    }

		List<Ticket> assignedTicket = tRepo.findByAssignedToId(csrId);
		List<TicketDto> alldto = new ArrayList<>();
		for(Ticket all : assignedTicket) {
			TicketDto dto = mapper.map(all, TicketDto.class);
			alldto.add(dto);
		}
		return alldto;
	}
}
