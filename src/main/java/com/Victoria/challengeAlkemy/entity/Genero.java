package com.Victoria.challengeAlkemy.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;


public class Genero implements Serializable{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	
	@OneToOne
    private Foto foto;
	
	@Column
	private String nombre;

	
	@Column
	private Boolean estado = true;

	@OneToMany
	private List <Pelicula> listaPeliculas; /*peliculas asociadas*/
	
	public Genero() {
    }

	public Genero(String id, Foto foto, String nombre, Boolean estado, List<Pelicula> listaPeliculas) {
		super();
		this.id = id;
		this.foto = foto;
		this.nombre = nombre;
		this.estado = estado;
		this.listaPeliculas = listaPeliculas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
	
	
}
