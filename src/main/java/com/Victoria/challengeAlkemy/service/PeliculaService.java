package com.Victoria.challengeAlkemy.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Victoria.challengeAlkemy.entity.Foto;
import com.Victoria.challengeAlkemy.entity.Pelicula;
import com.Victoria.challengeAlkemy.entity.Personaje;
import com.Victoria.challengeAlkemy.exceptions.WebException;
import com.Victoria.challengeAlkemy.repository.PeliculaRepository;
import com.Victoria.challengeAlkemy.repository.PersonajeRepository;

@Service
public class PeliculaService {
	
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Autowired
	private FotoService fotoService;

	@Transactional
	public Pelicula buscarPelicula(String nombre) {
		return peliculaRepository.findByNombre(nombre);
	}

	@Transactional
	public Optional<Pelicula> buscarPeliculaID(String id) {
		return peliculaRepository.findById(id);
	}

	@Transactional
	public Pelicula altaPelicula(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Transactional
	public Pelicula bajaPelicula(String id) throws WebException {
		Optional<Pelicula> rta = peliculaRepository.findById(id);
		if (rta.isPresent()) {
			if (rta.get().getEstado())
				rta.get().setEstado(false);
			else
				rta.get().setEstado(true);
		} else {
			throw new WebException("No se encontró la pelicula solicitada");
		}
		return peliculaRepository.save(rta.get());
	}

	public List<Pelicula> listarPelicula() {
		return peliculaRepository.findAll();
	}

	public List<Pelicula> listarPeliculaActivas() {
		List<Pelicula> pelicula = peliculaRepository.findAll();
		List<Pelicula> activas = new ArrayList();
		for (Pelicula pelicula : pelicula) {
			if (pelicula.getEstado()) {
				if (pelicula.getFoto() != null)
					pelicula.getFoto().setNombre(Base64.encodeBase64String(pelicula.getFoto().getContenido()));
				activas.add(pelicula);
			}
		}
		return activas;
	}

	// Metodo creado para el uso exclusivo de los administradores
	public void registrar ( String titulo, Date fechaCreacion, Integer calificacion, String historia,
			Boolean estado, MultipartFile archivo) throws WebException{

	
         Pelicula pelicula= new Pelicula ();
		
	      pelicula.setCalificacion(calificacion);
	      pelicula.setEstado(estado);
	      pelicula.setFechaCreacion(fechaCreacion);
          pelicula.setHistoria(historia);
          pelicula.setTitulo(titulo);

          Foto foto = fotoService.guardarFoto(archivo);
	      pelicula.setFoto(foto);

	      PeliculaRepository.save(pelicula);
}
	

	// Metodo creado para el uso exclusivo de los administradores
	
	public void modificar ( String titulo, Date fechaCreacion, Integer calificacion, String historia,
			Boolean estado, MultipartFile archivo, String id) throws WebException{

	
		Optional<Pelicula> rta = peliculaRepository.findById(id);
		if (rta.isPresent()) {
			Pelicula pelicula = rta.get();
		
	      pelicula.setCalificacion(calificacion);
	      pelicula.setFechaCreacion(fechaCreacion);
          pelicula.setHistoria(historia);
          pelicula.setTitulo(titulo);
          
          String idFoto = null;
			if (pelicula.getFoto() != null) {
				idFoto = pelicula.getFoto().getId();
			}
          
             
	      
	      
	  	Foto foto = fotoService.actualizarFoto(idFoto, archivo);
		pelicula.setFoto(foto);

		peliculaRepository.save(pelicula);
	} else {
		throw new WebException("No se encontró la pelicula solicitada");
	}

}
	      
	      
	     
}