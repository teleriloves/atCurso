package com.example.demo.service.appointment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.PageReqConfig;
import com.example.demo.dao.AppointmentDao;
import com.example.demo.dao.AppointmentDao;
import com.example.demo.dto.AppointmentDTO;
import com.example.demo.exceptions.NotFoundExcept;
import com.example.demo.dto.AppointmentDTO;
import com.example.demo.model.Appointment;
import com.example.demo.model.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private DozerBeanMapper dozer;
	


	@Override
	public AppointmentDTO findById(Integer id) throws NotFoundExcept {
		final Appointment a = Optional.ofNullable(appointmentDao.findOne(id)).orElseThrow(() -> new NotFoundExcept());
		return map(a);
	}

	@Override
	public List<AppointmentDTO> findAll(Integer page, Integer size) {
		final Iterable<Appointment> findAll = appointmentDao.findAll(PageReqConfig.newPageRequest(page, size));
		final List<AppointmentDTO> res = new ArrayList<>();
		findAll.forEach(a -> {final AppointmentDTO aDTO = map(a); res.add(aDTO);});
		return res;
	}

	@Override
	public AppointmentDTO create(AppointmentDTO appointmentDTO) {
		final Appointment p = map(appointmentDTO);
		return map(appointmentDao.save(p));
	}

	@Override
	public void update(AppointmentDTO appointmentDTO) {
		final Appointment p = map(appointmentDTO);
		appointmentDao.save(p);
	}

	@Override
	public void delete(Integer idAppointment) {
		appointmentDao.delete(idAppointment);
	}

	@Override
	public Appointment map(AppointmentDTO appointment) {
		return dozer.map(appointment, Appointment.class);
	}

	@Override
	public AppointmentDTO map(Appointment appointment) {
		return dozer.map(appointment, AppointmentDTO.class);
	}

}
