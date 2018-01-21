package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PatientDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.dto.PatientDTO;
import com.example.demo.service.patient.PatientService;
import com.example.demo.service.patient.PatientService;

@RestController
@RequestMapping(value = "api/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PatientDTO> retrieveAll()
	{
		return patientService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PatientDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		return patientService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public PatientDTO create(@RequestBody PatientDTO patient) 
	{
		return patientService.create(patient);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody PatientDTO patient) 
	{	
		patientService.update(patient);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		patientService.delete(id);
	}
	
}
