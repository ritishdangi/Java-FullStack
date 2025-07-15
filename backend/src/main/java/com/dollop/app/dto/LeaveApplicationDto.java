package com.dollop.app.dto;

import java.util.Date;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveApplicationDto {
	private Integer id;

    @NotNull(message = "Employee is required")
    private EmployeeDto employee;

    @NotNull(message = "Leave type is required")
    private LeaveTypeDto leaveType;

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date must be today or in the future")
    private Date startDate;

    @NotNull(message = "End date is required")
    @FutureOrPresent(message = "End date must be today or in the future")
    private Date endDate;

    @NotBlank(message = "Leave reason is required")
    private String reason;

    private String status = "PENDING";
}
