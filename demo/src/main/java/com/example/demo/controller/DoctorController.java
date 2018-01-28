package com.example.demo.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.service.doctor.DoctorService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(value = "api/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DoctorDTO> retrieveAll(@RequestParam(required=false) Integer page,  @RequestParam(required = false) Integer size)
	{
		log.info("Recuperacion de datos de doctores.");
		return doctorService.findAll(page, size);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DoctorDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		log.info("Recuperacion de datos de doctor" +id +".");
		return doctorService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public DoctorDTO create(@RequestBody DoctorDTO doctor) 
	{
		log.info("Creacion de doctor");
		return doctorService.create(doctor);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody DoctorDTO doctor) 
	{	
		log.info("Actualización de doctor"+id);
		doctorService.update(id,doctor);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		log.info("Eliminado doctor "+id);
		doctorService.delete(id);
	}

	@RequestMapping(value = "/{id}/stats", method = RequestMethod.GET)
	public Double retrieveDoctorStats(@PathVariable("id") Integer id, @RequestParam String initDate, @RequestParam String endDate) throws NotFoundExcept, ParseException
	{
		return doctorService.getDoctorStats(id, initDate, endDate);
	}
	
	@RequestMapping(value = "/rank/{amountOfDoctors}", method = { RequestMethod.GET })
	public List<DoctorDTO> getDoctorsWithMorePatients(@PathVariable("amountOfDoctors") Integer amount) 
	{
		log.info(amount+"doctores con más pacientes recuperados");
		return doctorService.getDoctorsWithMorePatients(amount);
	}
	
	
}
