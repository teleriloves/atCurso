package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Lazy;

@Entity
public class Film {
	
	@Id
	@GeneratedValue
	Integer id;
	
	private String title;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	

}
