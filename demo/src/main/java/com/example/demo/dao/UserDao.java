package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;


															
public interface UserDao extends PagingAndSortingRepository<User, Integer>{

	
	public List<User> findByName(@Param(value = "name") String name);
	
}
