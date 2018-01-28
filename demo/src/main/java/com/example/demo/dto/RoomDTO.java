package com.example.demo.dto;

import javax.persistence.Column;

import com.example.demo.model.Clinic;

public class RoomDTO {
	
	private Integer id;

	private Integer roomNumber;
	
	private Clinic clinic; 



	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

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

	
}
