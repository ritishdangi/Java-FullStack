package com.dollop.app.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dollop.app.dto.LeaveApplicationDto;
import com.dollop.app.model.LeaveApplication;

@Component
public class LeaveApplicationMapper {
	@Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private LeaveTypeMapper leaveTypeMapper;
    
    public LeaveApplication toEntity(LeaveApplicationDto dto) {
        if (dto == null) {
            return null;
        }

        LeaveApplication entity = new LeaveApplication();
        entity.setId(dto.getId());
        entity.setEmployee(employeeMapper.toEntity(dto.getEmployee()));
        entity.setLeaveType(leaveTypeMapper.toEntity(dto.getLeaveType()));
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setReason(dto.getReason());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
