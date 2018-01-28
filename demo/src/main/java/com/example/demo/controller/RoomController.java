package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoomDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.service.room.RoomService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping(value = "api/room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<RoomDTO> retrieveAll(@RequestParam(required=false) Integer page,  @RequestParam(required = false) Integer size)
	{
		log.info("Recuperacion de datos de habitaciones.");
		return roomService.findAll(page, size);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RoomDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		log.info("Recuperacion de datos de habitacion" +id +".");
		return roomService.findById(id);
	}
		
	@RequestMapping(method = { RequestMethod.POST })
	public RoomDTO create(@RequestBody RoomDTO room) 
	{
		log.info("Creacion de habitacion");
		return roomService.create(room);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void update(@PathVariable("id") Integer id, @RequestBody RoomDTO room) 
	{	
		log.info("Actualización de habitacion"+id);
		roomService.update(room);
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void delete(@PathVariable("id") Integer id) 
	{
		log.info("Eliminada habitacion "+id);
		roomService.delete(id);
	}
	
}
