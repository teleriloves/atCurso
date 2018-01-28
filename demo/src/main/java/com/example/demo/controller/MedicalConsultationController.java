package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MedicalConsultationDTO;
import com.example.demo.exceptions.NotFoundExcept;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(value = "api/medicalConsultation")
public class MedicalConsultationController {

	@Autowired
	private com.example.demo.service.medicalconsultation.MedicalConsultationService medicalConsultationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<MedicalConsultationDTO> retrieveAll(@RequestParam(required=false) Integer page,  @RequestParam(required = false) Integer size)
	{
		log.info("Recuperacion de datos de consultas.");
		return medicalConsultationService.findAll(page, size);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MedicalConsultationDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		log.info("Recuperacion de datos de consulta" +id +".");
		return medicalConsultationService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public MedicalConsultationDTO create(@RequestBody MedicalConsultationDTO medicalConsultation) 
	{
		log.info("Creacion de consulta");
		return medicalConsultationService.create(medicalConsultation);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody MedicalConsultationDTO medicalConsultation) 
	{	
		log.info("Actualización de consulta"+id);
		medicalConsultationService.update(id,medicalConsultation);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		log.info("Eliminada consulta "+id);
		medicalConsultationService.delete(id);
	}
	
}