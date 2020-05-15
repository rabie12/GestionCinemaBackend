package com.cinema.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.entities.Film;
import com.cinema.entities.Ticket;
import com.cinema.entities.TicketForm;
import com.cinema.repository.FilmRepository;
import com.cinema.repository.TicketRepository;

import lombok.Data;

@RestController
public class CinemaController {
	@Autowired
	private FilmRepository filmRepo;
	@Autowired
	private TicketRepository ticketRepo;
	
	@GetMapping(path="/images/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] images(@PathVariable(name="id") Long id) throws IOException {
      Film film=filmRepo.findById(id).get();
      String photoName= film.getPhoto();
      File file=new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
      Path path=Paths.get(file.toURI());
      return Files.readAllBytes(path);
      
	}
	@PostMapping("/payerTickets")
	@Transactional
	public List<Ticket> payerTicket(@RequestBody TicketForm ticketForm){
		List<Ticket> tickets=new ArrayList<>();
		ticketForm.getTickets().forEach(id->{
			Ticket ticket=ticketRepo.findById(id).get();
			ticket.setNomClient(ticketForm.getNomClient());
			ticket.setReserve(true);
			ticketRepo.save(ticket);
			tickets.add(ticket);
		});
		return tickets;
		
	}
}

