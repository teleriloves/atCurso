package com.example.demo.dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Appointment;

public interface AppointmentDao extends PagingAndSortingRepository<Appointment, Integer>{
	
	

}
