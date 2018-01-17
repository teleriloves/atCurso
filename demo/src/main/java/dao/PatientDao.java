package dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import model.Patient;

public interface PatientDao extends PagingAndSortingRepository<Patient, Integer>{

}
