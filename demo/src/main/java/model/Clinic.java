package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Clinic {

	@Id
	Integer id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinic")
	ArrayList<Room> rooms = new ArrayList<Room>();
	
	
}
