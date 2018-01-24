package com.example.demo.service.medicalconsultation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MedicalConsultationDao;
import com.example.demo.dto.MedicalConsultationDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.MedicalConsultation;
import com.example.demo.model.MedicalConsultation;

@Service
public class MedicalConsultationServiceImpl implements MedicalConsultationService {
	
	@Autowired
	private MedicalConsultationDao medicalConsultationDao;
	
	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public MedicalConsultationDTO findById(Integer id) throws NotFoundExcept {
		final MedicalConsultation mc = Optional.ofNullable(medicalConsultationDao.findOne(id)).orElseThrow(() -> new NotFoundExcept());
		return map(mc);
	}

	@Override
	public List<MedicalConsultationDTO> findAll() {
		final Iterable<MedicalConsultation> findAll = medicalConsultationDao.findAll();
		final List<MedicalConsultationDTO> res = new ArrayList<>();
		findAll.forEach(mc -> {final MedicalConsultationDTO mcDTO = map(mc); res.add(mcDTO);});
		return res;
	}

	@Override
	public MedicalConsultationDTO create(MedicalConsultationDTO medicalConsultationDTO) {
		final MedicalConsultation mc = map(medicalConsultationDTO);
		return map(medicalConsultationDao.save(mc));
	}

	@Override
	public void update(Integer id, MedicalConsultationDTO medicalConsultationDTO) {
		final MedicalConsultation mc = map(medicalConsultationDTO);
		mc.setId(id);
		medicalConsultationDao.save(mc);
	}

	@Override
	public void delete(Integer idMedicalConsultation) {
		medicalConsultationDao.delete(idMedicalConsultation);
	}

	@Override
	public MedicalConsultation map(MedicalConsultationDTO medicalConsultation) {
		return dozer.map(medicalConsultation, MedicalConsultation.class);
	}

	@Override
	public MedicalConsultationDTO map(MedicalConsultation medicalConsultation) {
		return dozer.map(medicalConsultation, MedicalConsultationDTO.class);
	}

}
