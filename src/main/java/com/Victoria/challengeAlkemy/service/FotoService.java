package com.Victoria.challengeAlkemy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Victoria.challengeAlkemy.entity.Foto;
import com.Victoria.challengeAlkemy.exceptions.WebException;
import com.Victoria.challengeAlkemy.repository.FotoRepository;

@Service
public class FotoService {
	   @Autowired
	    private FotoRepository fotoRepositorio;
	    
	    public Foto guardarFoto(MultipartFile archivo) throws WebException{
	        if(archivo != null){
	            try {
	                Foto foto = new Foto();
	                foto.setMime(archivo.getContentType());
	                foto.setNombre(archivo.getName());
	                foto.setContenido(archivo.getBytes());

	                return fotoRepositorio.save(foto);
	            
	            }catch (Exception e) {
	                System.err.println(e.getMessage());
	            }
	        }
	        return null;
	    }
	    
	    public Foto actualizarFoto(String idFoto, MultipartFile archivo) throws WebException{
	        if(archivo != null){
	            try {
	                Foto foto = new Foto();

	                if(idFoto != null){
	                    Optional<Foto> rta = fotoRepositorio.findById(idFoto);
	                    
	                    if(rta.isPresent()){
	                        foto = rta.get();
	                    }
	                }
	                foto.setMime(archivo.getContentType());
	                foto.setNombre(archivo.getName());
	                foto.setContenido(archivo.getBytes());

	                return fotoRepositorio.save(foto);
	            
	            }catch (Exception e) {
	                System.err.println(e.getMessage());
	            }   
	        }
	        return null;

	    }
	    
	
}
