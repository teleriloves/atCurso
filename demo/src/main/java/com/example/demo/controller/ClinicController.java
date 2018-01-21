package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClinicDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.service.clinic.ClinicService;

@RestController
@RequestMapping(value = "api/clinic")
public class ClinicController {

	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ClinicDTO> retrieveAll()
	{
		return clinicService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ClinicDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		return clinicService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public ClinicDTO create(@RequestBody ClinicDTO clinic) 
	{
		return clinicService.create(clinic);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody ClinicDTO clinic) 
	{	
		clinicService.update(clinic);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		clinicService.delete(id);
	}
	
}