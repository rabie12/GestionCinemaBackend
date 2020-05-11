package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinema.entities.Categorie;
import com.cinema.entities.Ville;


@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville, Long> {

}
