package com.dollop.app.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.dto.LeaveApplicationDto;
import com.dollop.app.exception.EmployeeNotFound;
import com.dollop.app.exception.LeaveApplicationNotFound;
import com.dollop.app.mapper.LeaveApplicationMapper;
import com.dollop.app.model.Employee;
import com.dollop.app.model.LeaveApplication;
import com.dollop.app.model.LeaveType;
import com.dollop.app.repository.IEmployeeRepo;
import com.dollop.app.repository.ILeaveApplicatioRepo;
import com.dollop.app.repository.ILeaveTypeRepo;
import com.dollop.app.services.ILeaveApplicationService;

@Service
public class LeaveApplicationServiceImpl implements ILeaveApplicationService {
	@Autowired
	private ILeaveApplicatioRepo lRepo;

	@Autowired
	private LeaveApplicationMapper lMapper;

	@Autowired
	private ILeaveTypeRepo leaveTypeRepository;

	@Autowired
	private IEmployeeRepo eRepo;

	@Override
	public LeaveApplication applyLeave(LeaveApplicationDto leaveapplicationdto) {
		Integer leaveTypeId = leaveapplicationdto.getLeaveType().getId();
		LeaveType leaveType = leaveTypeRepository.findById(leaveTypeId)
				.orElseThrow(() -> new LeaveApplicationNotFound("Invalid Leave Type ID"));

		if (leaveapplicationdto.getStartDate().after(leaveapplicationdto.getEndDate())) {
			throw new LeaveApplicationNotFound("Start date must be before end date.");
		}

		long daysRequested = ((leaveapplicationdto.getEndDate().getTime()
				- leaveapplicationdto.getStartDate().getTime()) / (1000 * 60 * 60 * 24)) + 1;

		if (daysRequested > leaveType.getMaxDay()) {
			throw new LeaveApplicationNotFound("Requested leave days exceed max allowed for this leave type.");
		}

		Integer empId = leaveapplicationdto.getEmployee().getEmpId();
		Optional<Employee> empl = Optional.ofNullable(
				eRepo.findById(empId).orElseThrow(() -> new EmployeeNotFound("Employee Not Found With ID:" + empId)));

		List<LeaveApplication> existingLeaves = lRepo.findByEmployeeEmpId(empId);
		for (LeaveApplication existing : existingLeaves) {
			boolean overlaps = !(leaveapplicationdto.getEndDate().before(existing.getStartDate())
					|| leaveapplicationdto.getStartDate().after(existing.getEndDate()));
			if (overlaps) {
				throw new LeaveApplicationNotFound("Overlapping leave exists for the given dates.");
			}
		}
		LeaveApplication lapplication = lMapper.toEntity(leaveapplicationdto);
		return lRepo.save(lapplication);
	}

	@Override
	public Optional<LeaveApplication> getLeaveApplicationById(Integer id) {
		Optional<LeaveApplication> leave = lRepo.findById(id);
		if (!leave.isPresent()) {
			throw new LeaveApplicationNotFound("application Not Found With ID: " + id);
		}
		return null;
	}

	@Override
	public List<LeaveApplication> getAllLeaveApplications() {
		return lRepo.findAll();
	}

	@Override
	public LeaveApplication approveApplication(Integer id) {
		Optional<LeaveApplication> exist = lRepo.findById(id);
		
		if (exist.isPresent()) {
			LeaveApplication leave = exist.get();
			leave.setStatus("APPROVED");
			lRepo.save(leave);
			return null;
		} else {
			throw new LeaveApplicationNotFound("application Not Found With ID: " + id);
		}
	}

	@Override
	public LeaveApplication rejectApplication(Integer id) {
		LeaveApplication exist = lRepo.findById(id).get();
		if(exist != null) {
			if(exist.getStatus().equals("REJECTED") || exist.getStatus().equals("APPROVED")) {
				throw new LeaveApplicationNotFound("This Application Already "+ exist.getStatus());
			}
			exist.setStatus("REJECTED");
		}
		return exist;
	}
}
