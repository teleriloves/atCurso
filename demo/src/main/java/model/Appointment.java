package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Patient patient;
	
	@OneToOne(fetch = FetchType.LAZY)
	private MedicalConsultation medicalconsultation;
	
}
