package com.dollop.app.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.dto.LeaveTypeDto;
import com.dollop.app.exception.LeaveApplicationNotFound;
import com.dollop.app.mapper.LeaveTypeMapper;
import com.dollop.app.model.LeaveType;
import com.dollop.app.repository.ILeaveTypeRepo;
import com.dollop.app.services.ILeaveTypeService;

@Service
public class LeaveTypeServiceImpl implements ILeaveTypeService {
	@Autowired
	private ILeaveTypeRepo leaveTypeRepo;
	@Autowired
	private LeaveTypeMapper lMapper;

	@Override
	public LeaveType createLeaveType(LeaveTypeDto leaveType) {
		Optional<LeaveType> lt = leaveTypeRepo.findByName(leaveType.getName());
		if(lt.isPresent()) {
			throw new LeaveApplicationNotFound("LeaveType Already Exist");
		}
		LeaveType ltype = lMapper.toEntity(leaveType);
		return leaveTypeRepo.save(ltype);
	}

	@Override
	public List<LeaveType> getAllLeaveTypes() {
		return leaveTypeRepo.findAll();
	}
	
}
