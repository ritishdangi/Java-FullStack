package com.dollop.app.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leaveApplic")
public class LeaveApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	@NotNull(message = "Employee is required")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "leave_type_id", nullable = false)
	@NotNull(message = "Leave type is required")
	private LeaveType leaveType;

	@NotNull(message = "Start date is required")
	@FutureOrPresent(message = "Start date must be today or in the future")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "End date is required")
	@FutureOrPresent(message = "End date must be today or in the future")
	private Date endDate;

	@NotBlank(message = "Leave reason is required")
	private String reason;

	@NotBlank(message = "Leave status is required")
	private String status = "PENDING";
}
