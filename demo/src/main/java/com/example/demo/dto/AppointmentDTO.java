package com.example.demo.dto;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

import com.example.demo.model.MedicalConsultation;
import com.example.demo.model.Patient;

public class AppointmentDTO {
	
	private Integer id;
	
	private Patient patient;
	
	private MedicalConsultation medicalconsultation;
	
	private Integer order;

}
