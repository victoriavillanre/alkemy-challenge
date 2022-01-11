package com.Victoria.challengeAlkemy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Victoria.challengeAlkemy.entity.Foto;
import com.Victoria.challengeAlkemy.entity.Genero;
import com.Victoria.challengeAlkemy.entity.Pelicula;
import com.Victoria.challengeAlkemy.entity.Personaje;
import com.Victoria.challengeAlkemy.exceptions.WebException;
import com.Victoria.challengeAlkemy.repository.GeneroRepository;
import com.Victoria.challengeAlkemy.repository.PersonajeRepository;

@Service
public class GeneroService {
	public void crear (String nombre, Boolean estado,MultipartFile archivo) throws WebException{

            Genero genero= new Genero();
		 	genero.setNombre(nombre);
	     	genero.setEstado();
		
		
            Foto foto = fotoService.guardarFoto(archivo);
	        genero.setFoto(foto);
 
	        GeneroRepository.save(personaje);
}
	
	
	
	public List<Genero> listarGeneros() {
		List<Genero> generos = GeneroRepository.findAll();
		return generos;
	}
}
