package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinema.entities.Categorie;
import com.cinema.entities.Place;


@RepositoryRestResource
public interface PlaceRepository extends JpaRepository<Place, Long> {

}
