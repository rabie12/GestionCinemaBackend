package com.cinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entities.Categorie;
import com.cinema.entities.Cinema;
import com.cinema.entities.Film;
import com.cinema.entities.Place;
import com.cinema.entities.ProjectionFilm;
import com.cinema.entities.Salle;
import com.cinema.entities.Seance;
import com.cinema.entities.Ticket;
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
@Transactional
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
		Stream.of("Histoire","Drama","Action","Fiction").forEach(cat->{
			Categorie categorie=new Categorie();
			categorie.setNomCategorie(cat);
			categorieRepo.save(categorie);
		});
		

	}

	@Override
	public void initFilms() {
		double[] duree= {1,1.5,2,2.5,3};
		List<Categorie> categories= categorieRepo.findAll();
				Stream.of("You see me","Jocker","Vikings","Dark Night").forEach(titre->{
			Film film=new Film();
			film.setTitre(titre);
			film.setCategorie(categories.get(new Random().nextInt(categories.size())));
			film.setDuree(duree[new Random().nextInt(duree.length)]);
			film.setPhoto(titre.replace(" ", ""));
			filmRepo.save(film);
		});

	}

	@Override
	public void initProjections() {
		double [] prices= {10,20,40,50,60,90};
		villeRepo.findAll().forEach(ville-> {
			ville.getCinema().forEach(cinema->{ 
			cinema.getSalle().forEach(salle->{
				filmRepo.findAll().forEach(film->{
					seanceRepo.findAll().forEach(seance->
					{
						ProjectionFilm projection=new ProjectionFilm();
						projection.setFilm(film);
						projection.setSalle(salle);
						projection.setSeance(seance);
						projection.setPrix(prices[new Random().nextInt(prices.length)]);
						projectionFilmRepo.save(projection);
					});
					});
				
			});
			
		});

	});
	}
	@Override
	public void initTickets() {
		projectionFilmRepo.findAll().forEach(p->{
			p.getSalle().getPlaces().forEach(place->{
				Ticket ticket=new Ticket();
				ticket.setPlace(place);
				ticket.setProjection(p);
				ticket.setPrix(p.getPrix());
				ticket.setReserve(false);
				ticketRepo.save(ticket);
				
			});
			
		});

	}

}
