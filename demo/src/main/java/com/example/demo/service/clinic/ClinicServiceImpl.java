package com.example.demo.service.clinic;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClinicDao;
import com.example.demo.dto.ClinicDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Clinic;
import com.example.demo.model.Patient;

@Service
public class ClinicServiceImpl implements ClinicService{

	@Autowired
	private ClinicDao clinicDao;
	
	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public ClinicDTO findById(Integer id) {
		final Clinic c = clinicDao.findOne(id);
		return map(c);
	}

	@Override
	public List<ClinicDTO> findAll() {
		final Iterable<Clinic> findAll = clinicDao.findAll();
		final List<ClinicDTO> res = new ArrayList<>();
		findAll.forEach(c -> {final ClinicDTO cDTO = map(c); res.add(cDTO);});
		return res;
	}

	@Override
	public ClinicDTO create(ClinicDTO clinicDTO) {
		final Clinic c = map(clinicDTO);
		return map(clinicDao.save(c));
	}

	@Override
	public void update(ClinicDTO clinicDTO) {
		final Clinic c = map(clinicDTO);
		clinicDao.save(c);
	}

	@Override
	public void delete(Integer idClinic) {
		clinicDao.delete(idClinic);
	}

	@Override
	public Clinic map(ClinicDTO clinic) {
		return dozer.map(clinic, Clinic.class);
	}

	@Override
	public ClinicDTO map(Clinic clinic) {
		return dozer.map(clinic, ClinicDTO.class);
	}
	
}
