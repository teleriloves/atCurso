package com.example.demo.dto;

import javax.persistence.Column;

public class RoomDTO {
	
	private Integer id;

	private Integer roomNumber;

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
