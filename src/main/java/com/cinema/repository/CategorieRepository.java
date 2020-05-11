package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinema.entities.Categorie;


@RepositoryRestResource
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
