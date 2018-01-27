package com.example.demo.service.clinic;

import java.util.List;

import com.example.demo.dto.ClinicDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.RoomDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Clinic;

public interface ClinicService {
	
	public ClinicDTO findById(Integer id) throws NotFoundExcept;

	 public List<ClinicDTO> findAll(Integer page, Integer sizeS);

	public ClinicDTO create(ClinicDTO clinicDTO);

	public void update(ClinicDTO clinicDTO);

	public void delete(Integer idClinic);
	
	public List<RoomDTO> findClinicRooms(Integer idClinic);
	
	public List<DoctorDTO> findClinicDoctors(Integer idClinic);
	
	public List<PatientDTO> findClinicPatients(Integer idClinic);
	
	public Clinic map(ClinicDTO clinic);
	
	public ClinicDTO map(Clinic clinic);

}
