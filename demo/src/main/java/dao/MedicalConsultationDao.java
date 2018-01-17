package dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import model.Doctor;

public interface MedicalConsultationDao extends PagingAndSortingRepository<Doctor, Integer>{

}
