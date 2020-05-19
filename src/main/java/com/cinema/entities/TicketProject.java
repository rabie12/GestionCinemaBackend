package com.cinema.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticketsProj", types = { com.cinema.entities.Ticket.class })
public interface TicketProject {
	public Long getIdTicket();
	public String getNomClient();
	public double getPrix();
	public Integer getCodePaiement();
	public boolean getReserve();
	public Place getPlace();

}
