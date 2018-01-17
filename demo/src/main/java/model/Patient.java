package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue
	Integer id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
}
