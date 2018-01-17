package dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import model.Doctor;

public interface DoctorDao extends PagingAndSortingRepository<Doctor, Integer>{

}
