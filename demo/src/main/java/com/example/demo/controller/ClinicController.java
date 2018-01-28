package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClinicDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.RoomDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.service.clinic.ClinicService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(value = "api/clinic")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ClinicDTO> retrieveAll(@RequestParam(required=false) Integer page,  @RequestParam(required = false) Integer size)
	{
		log.info("Recuperacion de datos de clinicas.");
		return clinicService.findAll(page, size);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ClinicDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		log.info("Recuperacion de datos de clinica" +id +".");
		return clinicService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public ClinicDTO create(@RequestBody ClinicDTO clinic) 
	{
		log.info("Creacion de clinica");
		return clinicService.create(clinic);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody ClinicDTO clinic) 
	{	
		log.info("Actualización de clinica"+id);
		clinicService.update(clinic);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		log.info("Eliminada clinica "+id);
		clinicService.delete(id);
	}
	
	@RequestMapping(value = "/{id}/room")
	public List<RoomDTO> findClinicRooms(@PathVariable Integer id)
	{   log.info("Recuperadas habitaciones de la clinica "+id);
		return clinicService.findClinicRooms(id);
	}
	
	@RequestMapping(value = "/{id}/patient")
	public List<PatientDTO> findClinicPatients(@PathVariable Integer id)
	{
		log.info("Recuperados pacientes de la clinica "+id);
		return clinicService.findClinicPatients(id);
	}
	
	@RequestMapping(value = "/{id}/doctor")
	public List<DoctorDTO> findClinicDoctors(@PathVariable Integer id)
	{
		log.info("Recuperados doctores de la clinica "+id);
		return clinicService.findClinicDoctors(id);
	}
	
}