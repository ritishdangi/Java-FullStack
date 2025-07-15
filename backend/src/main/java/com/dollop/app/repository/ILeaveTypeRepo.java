package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.model.LeaveType;

public interface ILeaveTypeRepo extends JpaRepository<LeaveType, Integer> {
	Optional<LeaveType> findByName(String name);
}
