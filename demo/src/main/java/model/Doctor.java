package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Doctor {

	@Id
	Integer id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	ArrayList<MedicalConsultation> consultations = new ArrayList<MedicalConsultation>();
	
	
}
