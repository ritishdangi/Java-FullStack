package com.dollop.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	List<Ticket> findByUserId(Integer userId);
	List<Ticket> findByAssignedToId(Integer csrId);
}
