package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.MedicalConsultationDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.MedicalConsultation;
import com.example.demo.service.doctor.DoctorService;

@RestController
@RequestMapping(value = "api/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DoctorDTO> retrieveAll()
	{
		return doctorService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DoctorDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
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
		doctorService.update(id,doctor);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		doctorService.delete(id);
	}

	@RequestMapping(value = "/dbg", method = {RequestMethod .GET})
	public void retrieveDoctorsFromExternalApp()
	{
		//DoctorDTO result = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor?page=" + i, DoctorDTO.class);
		//List<DoctorDTO> result = restTemplate.postForEntity(url, request, responseType)
		//List<DoctorDTO> resultList = Arrays.asList(restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor?page=0", DoctorDTO[].class));
		//resultList.forEach(o -> doctorService.create(o));
		
		DoctorDTO[] result = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor?page=0", DoctorDTO[].class);
		for(int i = 0; i< result.length;++i) {
			doctorService.create(result[i]);

		}
		
	}
	
}
