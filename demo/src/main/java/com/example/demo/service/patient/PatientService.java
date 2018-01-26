package com.example.demo.service.patient;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Patient;


public interface PatientService {
	
	PatientDTO findById(Integer id) throws NotFoundExcept;

	List<PatientDTO> findAll();

	PatientDTO create(PatientDTO patientDTO);

	void update(PatientDTO patientDTO);

	void delete(Integer idPatient);
	
	public Patient map(PatientDTO patient);
	
	public PatientDTO map(Patient patient);
	
	public List<AppointmentDTO> findPatientAppointments(Integer idPatient);

}
