package com.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cinema.service.ICinemaInitService;

@SpringBootApplication
public class GestionCinemaApplication implements CommandLineRunner{
    @Autowired
    private ICinemaInitService cineInitService;
    
	public static void main(String[] args) {
		SpringApplication.run(GestionCinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cineInitService.initVilles();
		cineInitService.initCinemas();
		cineInitService.initSalles();
		
		cineInitService.initPlaces();
		
		cineInitService.initCategories();
		
		cineInitService.initFilms();
		cineInitService.initSeances();
		cineInitService.initProjections();
		cineInitService.initTickets();
		
		
		
		
		
		
		
	}

}
