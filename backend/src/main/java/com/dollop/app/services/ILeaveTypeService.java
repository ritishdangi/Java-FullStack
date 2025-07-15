package com.dollop.app.services;

import java.util.List;

import com.dollop.app.dto.LeaveTypeDto;
import com.dollop.app.model.LeaveType;

public interface ILeaveTypeService {
	LeaveType createLeaveType(LeaveTypeDto leaveType);

    List<LeaveType> getAllLeaveTypes();

}
