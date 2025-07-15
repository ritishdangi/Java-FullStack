package com.dollop.app.mapper;

import org.springframework.stereotype.Component;

import com.dollop.app.dto.LeaveTypeDto;
import com.dollop.app.model.LeaveType;

@Component
public class LeaveTypeMapper {
	public LeaveType toEntity(LeaveTypeDto dto) {
        if (dto == null) {
            return null;
        }
        LeaveType leaveType = new LeaveType();
        leaveType.setId(dto.getId());
        leaveType.setName(dto.getName());
        leaveType.setMaxDay(dto.getMaxDay());
        return leaveType;
    }
}
