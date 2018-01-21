package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.service.doctor.DoctorService;

@RestController
@RequestMapping(value = "api/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DoctorDTO> retrieveAll()
	{
		return doctorService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DoctorDTO findOne(@PathVariable("id") Integer id)
	{
		return doctorService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public DoctorDTO create(@RequestBody DoctorDTO doctor) 
	{
		return doctorService.create(doctor);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody DoctorDTO doctor) 
	{	
		doctorService.update(doctor);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		doctorService.delete(id);
	}

}
