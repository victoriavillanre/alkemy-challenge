package com.Victoria.challengeAlkemy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Victoria.challengeAlkemy.entity.Foto;
import com.Victoria.challengeAlkemy.entity.Personaje;
import com.Victoria.challengeAlkemy.exceptions.WebException;
import com.Victoria.challengeAlkemy.repository.PersonajeRepository;

@Service
public class PersonajeService {

	
	public void registrar (String nombre, Integer edad, Integer peso, String historia, Boolean estado, MultipartFile archiv, String id) throws WebException{

	Personaje personaje=  new Personaje();
    personaje.setEstado(estado);
    personaje.setHistoria(historia);
    personaje.setNombre(nombre);
    personaje.setPeso(peso);
    
    Foto foto = fotoService.guardarFoto(archivo);
	personaje.setFoto(foto);

	PersonajeRepository.save(personaje);
}
	
	public List<Personaje> listarPersonajes() {
		List<Personaje> personajes = PersonajeRepository.findAll();
		return personajes;
	}
	
}