package com.example.demo.service.doctor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.configuration.PageReqConfig;
import com.example.demo.dao.DoctorDao;
import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.dto.PriceDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.model.Doctor;
import com.example.demo.model.MedicalConsultation;
import com.example.demo.service.appointment.AppointmentService;
import com.example.demo.service.patient.PatientService;
import com.example.demo.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	static Integer NotANullId = -1;

	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public DoctorDTO findById(Integer id) throws NotFoundExcept {
		final Doctor d = Optional.ofNullable(doctorDao.findOne(id)).orElseThrow(() -> new NotFoundExcept());
		return map(d);
	}
	
	@Override
	public List<DoctorDTO> findAll(Integer page, Integer size) {
		final Iterable<Doctor> findAll = doctorDao.findAll(PageReqConfig.newPageRequest(page, size));
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
		d.setInternalId(id);
		doctorDao.save(d);
	}

	@Override
	public void delete(Integer idDoctor) {
		doctorDao.delete(idDoctor);
	}

	@Override
	public Doctor map(DoctorDTO doctor) {
		Doctor d =  Optional.ofNullable(doctorDao.findOne(Optional.ofNullable(doctor.getInternalId()).orElse(NotANullId))).orElse(new Doctor());
		d.setId(doctor.getId());
		d.setDni(doctor.getDni());
		d.setName(doctor.getName());
		return d;
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
	
	@PostConstruct
	public void retrieveDoctorsFromExternalApp()
	{
		DoctorDTO[] listDocs;
		Integer page = 0;
		do{
			ResponseEntity<DoctorDTO[]> resEntDoctors = restTemplate.getForEntity("http://doctor.dbgjerez.es:8080/api/doctor?page="+page, DoctorDTO[].class);
			listDocs = resEntDoctors.getBody();
			for(int i = 0; i< listDocs.length;++i) {
				create(listDocs[i]);
			}
			++page;
		}while(listDocs.length>0);
	}
	
	public List<DoctorDTO> getDoctorsWithMorePatients(Integer amountOfDoctorsToFind)
	{
		List<Doctor> doctors = doctorDao.findDoctorsWithMorePatients();
		List<DoctorDTO> listDTO = new ArrayList<>();
		doctors.stream().limit(amountOfDoctorsToFind).collect(Collectors.toList()).forEach(d -> listDTO.add(map(d)));
		return listDTO;	
	}
	
	
	public Double getDoctorStats(Integer internalId, String initDate, String endDate) throws NotFoundExcept, ParseException
	{
		Doctor doctor = doctorDao.findOne(internalId);
		Double doctorPrice = getDoctorPrice(doctor.getId());
		
		return doctorPrice*doctorAmountOfMedicalConsultations(doctor, initDate, endDate);
		
	}
	
	private Integer doctorAmountOfMedicalConsultations(Doctor doctor, String initDate, String endDate) throws ParseException 
	{
		List<MedicalConsultation> mcList = doctor.getConsultations();
		Integer amountOfConsultations = 0;
		for (MedicalConsultation medicalConsultation : mcList){
			if(dateInRange(medicalConsultation.getFecha(), initDate, endDate)) ++amountOfConsultations;
		}
		return amountOfConsultations;
	}
	
	public boolean dateInRange(String date, String init, String end) throws ParseException
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("DD-MM-YY");
		return (dateFormatter.parse(date).after(dateFormatter.parse(init)) && dateFormatter.parse(date).before(dateFormatter.parse(end)));
	}

	public Double getDoctorPrice(String id)
	{
		PriceDTO priceDTO = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor/"+id, PriceDTO.class);
		return priceDTO.getPrice();
	}
	
	
	
	
	
	
	

}
