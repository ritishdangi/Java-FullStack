package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.model.Role;
import com.dollop.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByName(String name);
	boolean existsByEmail(String email);
	boolean existsByRole(Role role);
	Optional<User> findByEmail(String email);
	List<User> findByRole(Role role);

}
