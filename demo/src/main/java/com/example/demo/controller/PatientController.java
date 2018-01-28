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
import com.example.demo.dto.PatientDTO;
import com.example.demo.exceptions.NotFoundExcept;

import com.example.demo.service.patient.PatientService;

import lombok.extern.java.Log;


@Log
@RestController
@RequestMapping(value = "api/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PatientDTO> retrieveAll(@RequestParam(required=false) Integer page,  @RequestParam(required = false) Integer size)
	{
		log.info("Recuperacion de datos de pacientes.");
		return patientService.findAll(page, size);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PatientDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		log.info("Recuperacion de datos de paciente" +id +".");
		return patientService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public PatientDTO create(@RequestBody PatientDTO patient) 
	{
		log.info("Creacion de paciente");
		return patientService.create(patient);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody PatientDTO patient) 
	{	
		log.info("Actualización de paciente"+id);
		patientService.update(patient);
	}

	@RequestMapping(value = "/{id}/", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		log.info("Eliminado paciente "+id);
		patientService.delete(id);
	}
	
	@RequestMapping(value = "/{id}/appointment", method = RequestMethod.GET)
	public List<AppointmentDTO> findPatientAppointments(Integer id)
	{
		log.info("Recuperadas citas del paciente "+id);
		return patientService.findPatientAppointments(id);
	}
}

