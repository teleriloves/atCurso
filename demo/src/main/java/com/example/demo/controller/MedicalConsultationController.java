package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MedicalConsultationDTO;
import com.example.demo.exceptions.NotFoundExcept;


@RestController
@RequestMapping(value = "api/medicalConsultation")
public class MedicalConsultationController {

	@Autowired
	private com.example.demo.service.medicalconsultation.MedicalConsultationService medicalConsultationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<MedicalConsultationDTO> retrieveAll()
	{
		return medicalConsultationService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MedicalConsultationDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		return medicalConsultationService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public MedicalConsultationDTO create(@RequestBody MedicalConsultationDTO medicalConsultation) 
	{
		return medicalConsultationService.create(medicalConsultation);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody MedicalConsultationDTO medicalConsultation) 
	{	
		medicalConsultationService.update(medicalConsultation);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		medicalConsultationService.delete(id);
	}
	
}