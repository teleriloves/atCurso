package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.service.appointment.AppointmentService;

@RestController
@RequestMapping(value = "api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AppointmentDTO> retrieveAll()
	{
		return appointmentService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AppointmentDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		return appointmentService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public AppointmentDTO create(@RequestBody AppointmentDTO appointment) 
	{
		return appointmentService.create(appointment);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody AppointmentDTO appointment) 
	{	
		appointmentService.update(appointment);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		appointmentService.delete(id);
	}
	
}