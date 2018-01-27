package com.example.demo.service.clinic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.PageReqConfig;
import com.example.demo.dao.ClinicDao;
import com.example.demo.dto.ClinicDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.RoomDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Clinic;
import com.example.demo.model.Clinic;
import com.example.demo.model.Patient;
import com.example.demo.model.Room;
import com.example.demo.service.doctor.DoctorService;
import com.example.demo.service.medicalconsultation.MedicalConsultationService;
import com.example.demo.service.patient.PatientService;
import com.example.demo.service.room.RoomService;

@Service
public class ClinicServiceImpl implements ClinicService{

	@Autowired
	private ClinicDao clinicDao;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private PatientService patientService;
	 
	@Autowired
	private MedicalConsultationService medicalConsultationService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public ClinicDTO findById(Integer id) throws NotFoundExcept {
		final Clinic c = Optional.ofNullable(clinicDao.findOne(id)).orElseThrow(() -> new NotFoundExcept());
		return map(c);
	}

	@Override
	public List<ClinicDTO> findAll(Integer page, Integer size) {
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
//		Clinic c = new Clinic();
//		if(c == null) c = new Clinic();
//		c.setRooms(c.getRooms());
//		return c;
		return dozer.map(clinic, Clinic.class);
	}

	@Override
	public ClinicDTO map(Clinic clinic) {
		return dozer.map(clinic, ClinicDTO.class);
	}

	@Override
	public List<RoomDTO> findClinicRooms(Integer idClinic) {
		Clinic clinic = clinicDao.findOne(idClinic);
		List<RoomDTO> clinicRooms = new ArrayList<RoomDTO>();
		clinic.getRooms().forEach(r -> clinicRooms.add(roomService.map(r)));
		return clinicRooms;		
	}

	@Override
	public List<DoctorDTO> findClinicDoctors(Integer idClinic) {
		Clinic clinic = clinicDao.findOne(idClinic);
		List<DoctorDTO> clinicDoctors = new ArrayList<DoctorDTO>();
		clinic.getRooms().forEach(r -> r.getConsultations().forEach(d -> clinicDoctors.add(doctorService.map(d.getDoctor()))));
		return clinicDoctors;
		
	}

	@Override
	public List<PatientDTO> findClinicPatients(Integer idClinic) {
		Clinic clinic = clinicDao.findOne(idClinic);
		List<PatientDTO> clinicPatients = new ArrayList<PatientDTO>();
		clinic.getRooms().forEach(r -> r.getConsultations().forEach(a -> a.getAppointments().forEach(p -> clinicPatients.add(patientService.map(p.getPatient())))));
		return clinicPatients;
	}
	
}
