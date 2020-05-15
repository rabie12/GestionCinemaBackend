package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cinema.entities.Categorie;
import com.cinema.entities.Salle;


@RepositoryRestResource
@CrossOrigin("*")
public interface SalleRepository extends JpaRepository<Salle, Long> {

}
