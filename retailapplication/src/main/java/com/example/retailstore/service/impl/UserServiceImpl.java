package com.example.retailstore.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.Role;
import com.example.retailstore.model.User;
import com.example.retailstore.repositories.UserRepository;
import com.example.retailstore.service.UserService;
import com.example.retailstore.repositories.RoleRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRespository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Attempts to create a new row in the Users table.
	 * First checks if the object already exists. If so, do nothing, otherwise perform the insert.
	 *
	 * @param user the object to be inserted into the database
	 */
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRespository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	/**
	 * Retrieves a specific row from the Categories table by the email provided.
	 *
	 * @param email The email of the row being searched for.
	 * @return User if found, null if not found
	 */
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	/**
	 * Retrieves all rows from the Users table.
	 * 
	 * @return List
	 */
	@Override
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
}
