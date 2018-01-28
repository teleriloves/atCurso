package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.service.appointment.AppointmentService;

import lombok.extern.java.Log;
@Log
@RestController
@RequestMapping(value = "api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AppointmentDTO> retrieveAll(@RequestParam(required=false) Integer page,  @RequestParam(required = false) Integer size)
	{
		log.info("Recuperacion de datos de citas.");
		return appointmentService.findAll(page, size);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AppointmentDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		log.info("Recuperacion de datos de cita" +id +".");
		return appointmentService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public AppointmentDTO create(@RequestBody AppointmentDTO appointment) 
	{
		log.info("Creacion de cita");
		return appointmentService.create(appointment);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody AppointmentDTO appointment) 
	{	
		log.info("Actualización de cita "+id);
		appointmentService.update(appointment);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		log.info("Eliminada cita "+id);
		appointmentService.delete(id);
	}
	
}