package com.example.demo.model;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MedicalConsultation {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalconsultation")
	private List<Appointment> consultations = new ArrayList<Appointment>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Doctor doctor;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Room room;
	
	@Temporal(value = TemporalType.DATE)
	private Date fecha;
	
	@Enumerated(EnumType.STRING)
	private Switch docswitch;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Appointment> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Appointment> consultations) {
		this.consultations = consultations;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	//SI
	public Switch getDocswitch() {
		return docswitch;
	}

	public void setDocswitch(Switch docswitch) {
		this.docswitch = docswitch;
	}
	
	
	
	
	
	

}
