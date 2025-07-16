package com.dollop.app.dto;

import java.time.LocalDateTime;

import com.dollop.app.model.Priority;
import com.dollop.app.model.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
	private Integer id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Priority is required")
    private Priority priority;

    @NotNull(message = "Status is required")
    private Status status;

//    @NotNull(message = "AssignedTo user ID is required")
    private Integer assignedToId;

    @NotNull(message = "CreatedBy user ID is required")
    private Integer userId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
