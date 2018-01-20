package com.example.demo.dao;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Doctor;
import com.example.demo.model.User;

public interface DoctorDao extends PagingAndSortingRepository<Doctor, Integer>{

	public List<Doctor> findByName(@Param(value = "name") String name);
	
	public Doctor findByDni(@Param(value = "dni") String dni);
	
	public Doctor findById(@Param(value = "id") Integer id);
	
}
