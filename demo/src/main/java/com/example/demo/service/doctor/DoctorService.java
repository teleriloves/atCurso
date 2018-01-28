package com.example.demo.service.doctor;

import java.text.ParseException;
import java.util.List;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Doctor;

public interface DoctorService {
	
	DoctorDTO findById(Integer id) throws NotFoundExcept;

	List<DoctorDTO> findAll(Integer page, Integer size);

	DoctorDTO create(DoctorDTO doctorDTO);

	void update(Integer id, DoctorDTO doctorDTO);

	void delete(Integer idDoctor);
	
	public Doctor map(DoctorDTO doctor);
	
	public DoctorDTO map(Doctor doctor);
	
	public List<PatientDTO> findDoctorPatients(Integer idDoctor);
	
	public List<AppointmentDTO> findDoctorAppointments(Integer idDoctor);
	
	public void retrieveDoctorsFromExternalApp();
	
	public List<DoctorDTO> getDoctorsWithMorePatients(Integer amountOfDoctorsToFind);
	
	public Double getDoctorStats(Integer internalId, String initDate, String endDate) throws NotFoundExcept, ParseException;
	
	

}
