package com.example.demo.service.patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.PageReqConfig;
import com.example.demo.dao.PatientDao;
import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.exceptions.NotFoundExcept;

import com.example.demo.model.Patient;
import com.example.demo.service.appointment.AppointmentService;


@Service
public class PatientServiceImpl implements PatientService {
	
	private static final Integer NotANullId = -1;

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public PatientDTO findById(Integer id) throws NotFoundExcept {
		final Patient p = Optional.ofNullable(patientDao.findOne(id)).orElseThrow(() -> new NotFoundExcept());
		return map(p);
	}

	@Override
	public List<PatientDTO> findAll(Integer page, Integer size) {
		final Iterable<Patient> findAll = patientDao.findAll(PageReqConfig.newPageRequest(page, size));
		final List<PatientDTO> res = new ArrayList<>();
		findAll.forEach(p -> {final PatientDTO pDTO = map(p); res.add(pDTO);});
		return res;
	}

	@Override
	public PatientDTO create(PatientDTO patientDTO) {
		final Patient p = map(patientDTO);
		return map(patientDao.save(p));
	}

	@Override
	public void update(PatientDTO patientDTO) {
		final Patient p = map(patientDTO);
		patientDao.save(p);
	}

	@Override
	public void delete(Integer idPatient) {
		patientDao.delete(idPatient);
	}

	@Override
	public Patient map(PatientDTO patient) {
		Patient p =  Optional.ofNullable(patientDao.findOne(Optional.ofNullable(patient.getId()).orElse(NotANullId))).orElse(new Patient());
		p.setId(patient.getId());
		p.setName(patient.getName());
		p.setDni(patient.getDni());
		return p;
	}

	@Override
	public PatientDTO map(Patient patient) {
		return dozer.map(patient, PatientDTO.class);
	}

	@Override
	public List<AppointmentDTO> findPatientAppointments(Integer idPatient) {
		Patient patient = patientDao.findById(idPatient);
		List<AppointmentDTO> patientAppointments = new ArrayList<AppointmentDTO>();
		patient.getAppointments().forEach(a -> patientAppointments.add(appointmentService.map(a)));
		return patientAppointments;
	}
	
	
	

}
