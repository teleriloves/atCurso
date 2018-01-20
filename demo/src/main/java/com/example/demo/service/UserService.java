package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;

public interface UserService {
	
	User findById(Integer id);

	List<User> findAll();

	User create(User u);

	void update(User u, Integer idUser);

	void delete(User u, Integer idUser);
	
	public User map(UserDTO user);
	
	public UserDTO map(User user);

}
