package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;


@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	/*
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size)
	{
		return userService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idUser}")
	public User findOneById(@PathVariable Integer idUser)
	{
		return userService.findById(idUser);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User u) 
	{
		return userService.create(u);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idUser}")
	public void update(@RequestBody User u, @PathVariable Integer idUser)
	{
		userService.update(u,idUser);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{idUser}")
	public void delete(@RequestBody User u, @PathVariable Integer idUser)
	{
		userService.delete(u, idUser);
	}

*/
}
