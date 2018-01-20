package com.example.demo.dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Room;

public interface RoomDao extends PagingAndSortingRepository<Room, Integer> {
	
	public Room findById(@Param(value = "id") Integer id);

}
