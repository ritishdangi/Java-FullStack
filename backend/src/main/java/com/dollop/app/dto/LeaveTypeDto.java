package com.dollop.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveTypeDto {
	
    private Integer id;

    @NotBlank(message = "Leave type name cannot be blank")
    private String name;

    @Min(value = 5, message = "Maximum days must be at least 1")
    private Integer maxDay;
}
