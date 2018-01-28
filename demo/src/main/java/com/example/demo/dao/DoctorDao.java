package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Doctor;
import com.example.demo.model.User;

public interface DoctorDao extends PagingAndSortingRepository<Doctor, Integer>{

	public List<Doctor> findByName(@Param(value = "name") String name);
	
	public Doctor findByDni(@Param(value = "dni") String dni);
	
	public Doctor findById(@Param(value = "internalId") Integer id);
	
	@Query(value = "SELECT doctor FROM Doctor doctor WHERE doctor.internalId = :id")
	public Doctor findOneByExternalID(@Param("id") String id);

	@Query(value = "select d from Doctor d join d.consultations c join c.appointments a group by d.internalId order by count(distinct a.patient) desc")
	public List<Doctor> findDoctorsWithMorePatients();
	
	
}
