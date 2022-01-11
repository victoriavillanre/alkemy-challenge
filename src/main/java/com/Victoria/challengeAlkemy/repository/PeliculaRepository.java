package com.Victoria.challengeAlkemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Victoria.challengeAlkemy.entity.Pelicula;
import com.Victoria.challengeAlkemy.entity.Personaje;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, String> {
	
	public Pelicula findByNombre(String nombre);

}
