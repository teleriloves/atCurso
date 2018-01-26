package com.example.demo.service.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DoctorDao;
import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Doctor;
import com.example.demo.service.appointment.AppointmentService;
import com.example.demo.service.patient.PatientService;
import com.example.demo.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public DoctorDTO findById(Integer id) throws NotFoundExcept {
		final Doctor d = Optional.ofNullable(doctorDao.findOne(id)).orElseThrow(() -> new NotFoundExcept());
		return map(d);
	}
	
	//meter el tamaño de pagina y tamaño en general
	@Override
	public List<DoctorDTO> findAll() {
		final Iterable<Doctor> findAll = doctorDao.findAll();
		final List<DoctorDTO> res = new ArrayList<>();
		findAll.forEach(d -> {final DoctorDTO dDTO = map(d); res.add(dDTO);});
		return res;
	}

	@Override
	public DoctorDTO create(DoctorDTO doctorDTO) {
		final Doctor d = map(doctorDTO);
		return map(doctorDao.save(d));
	}

	@Override
	public void update(Integer id, DoctorDTO doctorDTO) {
		final Doctor d = map(doctorDTO);
		d.setId(id);
		doctorDao.save(d);
	}

	@Override
	public void delete(Integer idDoctor) {
		doctorDao.delete(idDoctor);
	}

	@Override
	public Doctor map(DoctorDTO doctor) {
		return dozer.map(doctor, Doctor.class);
	}

	@Override
	public DoctorDTO map(Doctor doctor) {
		return dozer.map(doctor, DoctorDTO.class);
	}

	@Override
	public List<PatientDTO> findDoctorPatients(Integer idDoctor) {
		Doctor doctor = doctorDao.findById(idDoctor);
		List<PatientDTO> doctorPatients = new ArrayList<PatientDTO>();
		doctor.getConsultations().forEach(mc -> mc.getAppointments().forEach(p -> doctorPatients.add(patientService.map(p.getPatient()))));
		return doctorPatients;		
	}

	@Override
	public List<AppointmentDTO> findDoctorAppointments(Integer idDoctor) {
		Doctor doctor = doctorDao.findById(idDoctor);
		List<AppointmentDTO> doctorAppointments = new ArrayList<AppointmentDTO>();
		doctor.getConsultations().forEach(mc -> mc.getAppointments().forEach(a -> doctorAppointments.add(appointmentService.map(a))));
		return doctorAppointments;
		
	}

}
