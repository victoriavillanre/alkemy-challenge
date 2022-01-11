package com.Victoria.challengeAlkemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Victoria.challengeAlkemy.entity.Genero;
import com.Victoria.challengeAlkemy.entity.Personaje;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, String> {

	public Genero findByNombre(String nombre);
}
