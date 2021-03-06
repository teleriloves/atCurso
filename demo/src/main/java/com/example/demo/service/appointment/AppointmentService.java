package com.example.demo.service.appointment;

import java.util.List;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Appointment;


public interface AppointmentService {
	
	AppointmentDTO findById(Integer id) throws NotFoundExcept;

	List<AppointmentDTO> findAll(Integer page, Integer size);

	AppointmentDTO create(AppointmentDTO appointmentDTO);

	void update(AppointmentDTO appointmentDTO);

	void delete(Integer idAppointment);
	
	public Appointment map(AppointmentDTO idAppointment);
	
	public AppointmentDTO map(Appointment idAppointment);


}
