package com.example.demo.dto;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

import com.example.demo.model.MedicalConsultation;
import com.example.demo.model.Patient;

public class AppointmentDTO {
	
	private Integer id;
	
	private Integer sworder;

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
	
	

}
