package com.example.demo.dto;


import com.example.demo.model.Patient;

public class AppointmentDTO {
	
	private Integer id;
	
	private Integer sworder;
	
	private Patient patient;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSworder() {
		return sworder;
	}

	public void setSworder(Integer order) {
		this.sworder = order;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
