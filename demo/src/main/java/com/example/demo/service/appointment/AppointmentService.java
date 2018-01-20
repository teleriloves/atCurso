package com.example.demo.service.appointment;

import java.util.List;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Appointment;


public interface AppointmentService {
	
	AppointmentDTO findById(Integer id);

	List<AppointmentDTO> findAll();

	AppointmentDTO create(AppointmentDTO appointmentDTO);

	void update(AppointmentDTO appointmentDTO);

	void delete(Integer idAppointment);
	
	public Appointment map(AppointmentDTO idAppointment);
	
	public AppointmentDTO map(Appointment idAppointment);


}
