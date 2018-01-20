package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



//Para todas las clases que vayan relacionadas con una tabla añadimos entity, pero de JPA
@Entity
//@Table(name ="usuario")
public class User 
{
	@Id
	@GeneratedValue
	Integer id;
	
	String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	List<Film> films = new ArrayList<Film>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	
	
}
