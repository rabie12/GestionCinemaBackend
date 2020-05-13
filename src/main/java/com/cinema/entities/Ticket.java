package com.cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Ticket implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTickets;
	private String nomClient;
	private double prix;
	@Column(unique = true)
	private int codePaiement;
	private boolean reserve;
	@ManyToOne
	@JoinColumn(name = "idPlace")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Place place;
	@ManyToOne
	@JoinColumn(name = "idProjection")
	@JsonProperty(access = Access.WRITE_ONLY)
	private ProjectionFilm projection;

}
