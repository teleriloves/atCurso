package dao;


//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import model.Clinic;

public interface ClinicDao extends PagingAndSortingRepository<Clinic, Integer>{

}
