package com.cinema.entities;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="projection1"  , types = { com.cinema.entities.ProjectionFilm.class })
public interface ProjectionFilmProj {
	public Long getIdProjection();
	public double getPrix();
	public Date getDateProjection();
	public Salle getSalle();
	public Film getFilm();
	public Seance getSeance();
	public Collection<Ticket> getTickets();

}
