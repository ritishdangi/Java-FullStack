package com.dollop.app.service;

import java.util.List;

import com.dollop.app.dto.TicketDto;

public interface TicketService {
	// 1. Create a new ticket (customer)
    TicketDto createTicket(TicketDto ticketDto);

    // 2. Get all tickets of a specific user (for Customer Dashboard)
    List<TicketDto> getTicketsByUser(Integer userId);

    // 3. Get all tickets (for Admin or CSR)
    List<TicketDto> getAllTickets();

    // 4. Get a ticket by its ID (for viewing ticket detail + comments)
//    TicketDto getTicketById(Integer ticketId);

    // 5. Update status of a ticket (e.g., OPEN -> IN_PROGRESS -> RESOLVED)
    TicketDto updateTicketStatus(Integer ticketId, String status);

    // 6. Assign a ticket to a CSR (Admin/CSR only)
    TicketDto assignTicket(Integer ticketId, Integer csrUserId);
    
    List<TicketDto> getTicketAssignToCsr(Integer csrId);

}
