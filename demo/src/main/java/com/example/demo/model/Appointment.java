package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private MedicalConsultation medicalconsultation;
	
	@GeneratedValue
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

	public Integer getOrder() {
		return sworder;
	}

	public void setOrder(Integer order) {
		this.sworder = order;
	}
	
	
}
