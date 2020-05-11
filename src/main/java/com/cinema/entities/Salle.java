package com.cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor @NoArgsConstructor @ToString
public class Salle implements Serializable {
	
	private Long idSalle;
	private String nomSalle;
	private int nbrSalles;
	@ManyToOne
	private Cinema cinema;
	

}
