package com.dollop.app.services;

import java.util.List;
import java.util.Optional;

import com.dollop.app.dto.LeaveApplicationDto;
import com.dollop.app.model.LeaveApplication;

public interface ILeaveApplicationService {
	LeaveApplication applyLeave(LeaveApplicationDto leaveapplicationdto);
	Optional<LeaveApplication> getLeaveApplicationById(Integer id);
	List<LeaveApplication> getAllLeaveApplications();
	public LeaveApplication approveApplication(Integer id);
	public LeaveApplication rejectApplication(Integer id);

}
