package com.example.demo.service.patient;

import java.util.List;

import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Patient;




public interface PatientService {
	
	Patient findById(Integer id);

	List<Patient> findAll();

	Patient create(Patient u);

	void update(Patient u, Integer idPatient);

	void delete(Patient u, Integer idPatient);
	
	public Patient map(PatientDTO patient);
	
	public PatientDTO map(Patient patient);

}
