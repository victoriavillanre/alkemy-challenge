package com.Victoria.challengeAlkemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Victoria.challengeAlkemy.entity.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, String> {

}
