package com.example.demo.dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.MedicalConsultation;


public interface MedicalConsultationDao extends PagingAndSortingRepository<MedicalConsultation, Integer>{
	
	public MedicalConsultation findById(@Param(value = "id") Integer id);

}
