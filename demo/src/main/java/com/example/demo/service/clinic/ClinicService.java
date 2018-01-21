package com.example.demo.service.clinic;

import java.util.List;

import com.example.demo.dto.ClinicDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Clinic;

public interface ClinicService {
	
	ClinicDTO findById(Integer id) throws NotFoundExcept;

	List<ClinicDTO> findAll();

	ClinicDTO create(ClinicDTO clinicDTO);

	void update(ClinicDTO clinicDTO);

	void delete(Integer idClinic);
	
	public Clinic map(ClinicDTO clinic);
	
	public ClinicDTO map(Clinic clinic);

}
