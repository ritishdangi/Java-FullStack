package com.dollop.app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {
	    private Integer empId;

	    @NotBlank(message = "Employee name cannot be blank")
	    private String empName;

	    @NotBlank(message = "Email cannot be blank")
	    @Email(regexp ="^[a-z0-9+_.-]+@[a-z.]+$", message = "Invalid email format")
	    private String empEmail;

	    @NotBlank(message = "Department cannot be blank")
	    private String empDept;

	    @NotNull(message = "Joining date is required")
	    @PastOrPresent(message = "Joining date cannot be in the future")
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") 
	    private Date empJoining;
}
