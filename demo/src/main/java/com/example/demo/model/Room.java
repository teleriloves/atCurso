package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Room {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(unique = true)
	private Integer roomNumber;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	private List<MedicalConsultation> consultations = new ArrayList<MedicalConsultation>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Clinic clinic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<MedicalConsultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<MedicalConsultation> consultations) {
		this.consultations = consultations;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	public String toString()
	{
		return "" +id;
	}
	
	
}
