package com.example.demo.service.doctor;

import java.util.List;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Doctor;

public interface DoctorService {
	
	DoctorDTO findById(Integer id) throws NotFoundExcept;

	List<DoctorDTO> findAll();

	DoctorDTO create(DoctorDTO doctorDTO);

	void update(DoctorDTO doctorDTO);

	void delete(Integer idDoctor);
	
	public Doctor map(DoctorDTO doctor);
	
	public DoctorDTO map(Doctor doctor);

}
