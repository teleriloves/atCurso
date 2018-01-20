package com.example.demo.dao;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Patient;
import com.example.demo.model.User;

public interface PatientDao extends PagingAndSortingRepository<Patient, Integer>{
		
	public List<Patient> findByName(@Param(value = "name") String name);
	
	public Patient findByDni(@Param(value = "dni") String dni);
	
	public Patient findById(@Param(value = "id") Integer id);
	
}
