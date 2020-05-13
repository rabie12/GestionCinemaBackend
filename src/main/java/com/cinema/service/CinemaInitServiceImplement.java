package com.cinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entities.Cinema;
import com.cinema.entities.Place;
import com.cinema.entities.Salle;
import com.cinema.entities.Seance;
import com.cinema.entities.Ville;
import com.cinema.repository.CategorieRepository;
import com.cinema.repository.CinemaRepository;
import com.cinema.repository.FilmRepository;
import com.cinema.repository.PlaceRepository;
import com.cinema.repository.ProjectionFilmRepository;
import com.cinema.repository.SalleRepository;
import com.cinema.repository.SeanceRepository;
import com.cinema.repository.TicketRepository;
import com.cinema.repository.VilleRepository;

@Service
public class CinemaInitServiceImplement implements ICinemaInitService {
	@Autowired
	private VilleRepository villeRepo;
	@Autowired
	private CinemaRepository cinemaRepo;
	@Autowired
	private SalleRepository salleRepo;
	@Autowired
	private PlaceRepository placeRepo;
	@Autowired
	private SeanceRepository seanceRepo;
	@Autowired
	private FilmRepository filmRepo;
	@Autowired
	private TicketRepository ticketRepo;
	@Autowired
	private ProjectionFilmRepository projectionFilmRepo;
	@Autowired
	private CategorieRepository categorieRepo;

	@Override
	public void initVilles() {
		Stream.of("Casablanca", "Marrakech", "Rabat", "Tanger").forEach(nameVille -> {
			Ville ville = new Ville();
			ville.setNomVille(nameVille);
			villeRepo.save(ville);
		});

	}

	@Override
	public void initCinemas() {
		villeRepo.findAll().forEach(ville -> {
			Stream.of("Megarama", "IMAX", "RIF", "MegaMall", "Chahrazad").forEach(nomCinema -> {
				Cinema cinema = new Cinema();
				cinema.setNomCinema(nomCinema);
				cinema.setNbrSalles(3 + (int) (Math.random() * 3));
				cinema.setVille(ville);
				cinemaRepo.save(cinema);
			});
		});

	}

	@Override
	public void initSalles() {
		cinemaRepo.findAll().forEach(cinema -> {
			for (int i = 0; i < cinema.getNbrSalles(); i++) {
				Salle salle = new Salle();
				salle.setNomSalle("Salle " + i);
				salle.setCinema(cinema);
				salle.setNbrPlaces(15 + (int) (Math.random() * 20));
				salleRepo.save(salle);

			}

		});
	}

	@Override
	public void initPlaces() {
		salleRepo.findAll().forEach(salle -> {
			for (int i = 0; i < salle.getNbrPlaces(); i++) {
				Place place = new Place();
				place.setNumero(i + 1);
				place.setSalle(salle);
				placeRepo.save(place);
			}

		});

	}

	@Override
	public void initSeances() {
		DateFormat date=new SimpleDateFormat("HH:mm");
		Stream.of("15:00","17:00","19:00","21:00","23:00").forEach(s->{
			Seance seance=new Seance();
			try {
				seance.setHeureDebut(date.parse(s));
				seanceRepo.save(seance);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Override
	public void initCategories() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initFilms() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initProjections() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initTickets() {
		// TODO Auto-generated method stub

	}

}
