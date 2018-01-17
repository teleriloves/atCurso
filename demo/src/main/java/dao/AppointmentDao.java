package dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import model.Appointment;

public interface AppointmentDao extends PagingAndSortingRepository<Appointment, Integer>{
	
	

}
