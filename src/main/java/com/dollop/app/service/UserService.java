package com.dollop.app.service;

import java.util.List;

import com.dollop.app.dto.UserDto;
import com.dollop.app.model.User;

public interface UserService {
	UserDto register(UserDto userDto);
	User login(String email,String password);
	List<UserDto> getAllUsers();
	User getUserById(Integer id);
	List<User> getAllUserCsr();
}
