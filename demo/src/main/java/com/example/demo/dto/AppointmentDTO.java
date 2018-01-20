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
	
	private Integer sworder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public MedicalConsultation getMedicalconsultation() {
		return medicalconsultation;
	}

	public void setMedicalconsultation(MedicalConsultation medicalconsultation) {
		this.medicalconsultation = medicalconsultation;
	}

	public Integer getSworder() {
		return sworder;
	}

	public void setSworder(Integer order) {
		this.sworder = order;
	}
	
	

}
