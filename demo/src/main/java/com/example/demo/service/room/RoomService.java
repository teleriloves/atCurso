package com.example.demo.service.room;

import java.util.List;

import com.example.demo.dto.RoomDTO;
import com.example.demo.model.Room;

public interface RoomService {
	
	RoomDTO findById(Integer id);

	List<RoomDTO> findAll();

	RoomDTO create(RoomDTO roomDTO);

	void update(RoomDTO roomDTO);

	void delete(Integer idRoom);
	
	public Room map(RoomDTO room);
	
	public RoomDTO map(Room room);

}
