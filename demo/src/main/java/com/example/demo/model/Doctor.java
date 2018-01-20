package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Doctor {

	@Id
	private Integer id;
	
	private String name;
	
	private String dni;
		
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MedicalConsultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<MedicalConsultation> consultations) {
		this.consultations = consultations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	private List<MedicalConsultation> consultations = new ArrayList<MedicalConsultation>();
	
	
}