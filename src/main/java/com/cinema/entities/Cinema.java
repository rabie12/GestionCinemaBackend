package com.cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class Cinema implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCinema;
	private String nomCinema;
	private double longitude;
	private double latitude;
	private double altitude;
	private int nbrSalles;
	@OneToMany(mappedBy = "cinema") 
	private Collection<Salle> salle;
	@ManyToOne @JoinColumn(name = "idVille")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Ville ville;
	
	
	
	
	

}
