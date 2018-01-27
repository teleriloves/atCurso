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
	private Integer id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalconsultation")
	private List<Appointment> appointments = new ArrayList<Appointment>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Doctor doctor;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Room room;
	
	private String fecha;
	
	@Enumerated(EnumType.STRING)
	private Switch docswitch;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> consultations) {
		this.appointments = consultations;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	//SI
	public Switch getDocswitch() {
		return docswitch;
	}

	public void setDocswitch(Switch docswitch) {
		this.docswitch = docswitch;
	}
	
	public String toString()
	{
		return "" +id;
	}
	
	
	
	
	

}
