package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class MedicalConsultation {
	
	@Id
	Integer id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalconsultation")
	ArrayList<MedicalConsultation> consultations = new ArrayList<MedicalConsultation>();
	
	@OneToOne(fetch = FetchType.LAZY)
	private Doctor doctor;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Room room;
	
	
	
	
	

}
