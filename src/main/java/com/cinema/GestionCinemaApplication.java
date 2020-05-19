package com.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.cinema.entities.Film;
import com.cinema.entities.Place;
import com.cinema.entities.Salle;
import com.cinema.entities.Ticket;
import com.cinema.service.ICinemaInitService;

@SpringBootApplication
public class GestionCinemaApplication implements CommandLineRunner{
    @Autowired
    private ICinemaInitService cineInitService;
    @Autowired
    private RepositoryRestConfiguration restConfig;
    
	public static void main(String[] args) {
		SpringApplication.run(GestionCinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		restConfig.exposeIdsFor(Film.class, Salle.class, Place.class, Ticket.class);
		cineInitService.initVilles();
		cineInitService.initCinemas();
		cineInitService.initSalles();
		cineInitService.initPlaces();
		cineInitService.initSeances();
		cineInitService.initCategories();
		cineInitService.initFilms();
		cineInitService.initProjections();
		cineInitService.initTickets();
		
		
		
		
		
		
		
	}

}
