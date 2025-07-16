package com.dollop.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.dto.UserDto;
import com.dollop.app.exception.ResourceNotFound;
import com.dollop.app.model.Role;
import com.dollop.app.model.User;
import com.dollop.app.repository.UserRepository;
import com.dollop.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto register(UserDto userDto) {
		if (uRepo.existsByEmail(userDto.getEmail())) {
			throw new ResourceNotFound("Email already exist");
		}
		if (userDto.getRole().equals(Role.ADMIN)) {
			boolean existbyrole = uRepo.existsByRole(Role.ADMIN);
			if (existbyrole) {
				throw new ResourceNotFound("Admin already exist");
			}
		}
		User user = mapper.map(userDto,User.class);
		User save = uRepo.save(user);
		return mapper.map(save, UserDto.class);
	}

	@Override
	public User login(String email, String password) {
		User exist = uRepo.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFound("Invalid email or password"));

		if (!exist.getPassword().equals(password)) {
			throw new ResourceNotFound("Invalid Password");
		}
		return exist;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> all = uRepo.findAll();
		List<UserDto> uDto = new ArrayList<>();
		for(User us : all) {
			if(us.getRole().equals(Role.CUSTOMER)) {
				UserDto userD = mapper.map(us, UserDto.class);
				uDto.add(userD);
			}
		}
		return uDto;
	}

	@Override
	public User getUserById(Integer id) {
		User user = uRepo.findById(id).orElseThrow(()-> new ResourceNotFound("User not found"));
		return user;
	}

	@Override
	public List<User> getAllUserCsr() {
		return uRepo.findByRole(Role.CSR);
	}

}
