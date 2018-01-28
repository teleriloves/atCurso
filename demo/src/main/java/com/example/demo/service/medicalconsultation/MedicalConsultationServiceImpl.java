package com.example.demo.service.medicalconsultation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.PageReqConfig;
import com.example.demo.dao.MedicalConsultationDao;
import com.example.demo.dto.MedicalConsultationDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Appointment;
import com.example.demo.model.MedicalConsultation;
import com.example.demo.model.MedicalConsultation;

@Service
public class MedicalConsultationServiceImpl implements MedicalConsultationService {
	
	private static final Integer NotANullId = -1;

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
	public List<MedicalConsultationDTO> findAll(Integer page, Integer size) {
		final Iterable<MedicalConsultation> findAll = medicalConsultationDao.findAll(PageReqConfig.newPageRequest(page, size));
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
		MedicalConsultation mc =  Optional.ofNullable(medicalConsultationDao.findOne(Optional.ofNullable(medicalConsultation.getId()).orElse(NotANullId))).orElse(new MedicalConsultation());
		mc.setId(medicalConsultation.getId());
		mc.setDoctor(medicalConsultation.getDoctor());
		mc.setFecha(medicalConsultation.getFecha());
		mc.setRoom(medicalConsultation.getRoom());
		return mc;
	}

	@Override
	public MedicalConsultationDTO map(MedicalConsultation medicalConsultation) {
		return dozer.map(medicalConsultation, MedicalConsultationDTO.class);
	}

}
