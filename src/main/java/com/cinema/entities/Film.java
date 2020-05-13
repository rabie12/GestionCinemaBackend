package com.cinema.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.print.attribute.DateTimeSyntax;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilm;
	private String titre;
	private String description;
	private double duree;
	private String realisateur;
	private String photo;
	private Date dateSortie;
	@OneToMany(mappedBy = "film")
	private Collection<ProjectionFilm> projection;
	@ManyToOne 
	@JoinColumn(name = "idCategorie")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Categorie categorie;

}
