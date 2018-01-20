package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao dao; 
	 
	@Override
	public User findById(Integer id) {

		return dao.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return null; 
	}

	@Override
	public User create(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User u, Integer idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User u, Integer idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User map(UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO map(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
