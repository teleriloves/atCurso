package com.example.demo.dto;


import com.example.demo.model.Doctor;
import com.example.demo.model.Room;

public class MedicalConsultationDTO {
	
	private Integer id;
	
	private String fecha;

	private Room room;
	
	private Doctor doctor;

	
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


}
