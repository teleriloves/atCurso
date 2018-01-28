package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {

	
	@Id
	@GeneratedValue
	private Integer internalId;
	
	private String id;
	
	private String name;
	
	private String dni;

	public String getDni() {
		return dni;
	}



	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	private List<MedicalConsultation> consultations = new ArrayList<MedicalConsultation>();
	
	public String toString()
	{
		return "" +internalId;
	}

	public Integer getInternalId() {
		return internalId;
	}

	public void setInternalId(Integer internalId) {
		this.internalId = internalId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
