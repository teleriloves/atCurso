package com.example.demo.service.medicalconsultation;

import java.util.List;

import com.example.demo.dto.MedicalConsultationDTO;
import com.example.demo.model.MedicalConsultation;

public interface MedicalConsultationService {
	
	MedicalConsultationDTO findById(Integer id);

	List<MedicalConsultationDTO> findAll();

	MedicalConsultationDTO create(MedicalConsultationDTO medicalConsultationDTO);

	void update(MedicalConsultationDTO medicalConsultationDTO);

	void delete(Integer idMedicalConsultation);
	
	public MedicalConsultation map(MedicalConsultationDTO medicalConsultation);
	
	public MedicalConsultationDTO map(MedicalConsultation medicalConsultation);

}
