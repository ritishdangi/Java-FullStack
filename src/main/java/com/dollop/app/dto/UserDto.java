package com.dollop.app.dto;

import com.dollop.app.model.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private Integer id;
	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(regexp ="^[a-z0-9+_.-]+@[a-z.]+$", message = "Invalid email format")
	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
	private String password;

	private Role role;

}
