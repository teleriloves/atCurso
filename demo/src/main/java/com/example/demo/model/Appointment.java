package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Patient patient;
	
	@OneToOne(fetch = FetchType.LAZY)
	private MedicalConsultation medicalconsultation;
	
	@GeneratedValue//(generated o strategy)
	private Integer order;

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
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	
}
