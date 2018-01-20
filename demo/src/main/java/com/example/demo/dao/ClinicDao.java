package com.example.demo.dao;


//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Clinic;

public interface ClinicDao extends PagingAndSortingRepository<Clinic, Integer>{
	
	public Clinic findById(@Param(value = "id") Integer id);

}
