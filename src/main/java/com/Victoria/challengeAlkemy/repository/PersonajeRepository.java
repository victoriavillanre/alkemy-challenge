package com.Victoria.challengeAlkemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Victoria.challengeAlkemy.entity.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, String> {

	public Personaje findByNombre(String nombre);
	
}
