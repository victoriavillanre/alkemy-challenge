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

@Entity
public class Personaje implements Serializable {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	
	@OneToOne
    private Foto foto;
	
	@Column
	private String nombre;

	@Column
	private Integer edad;

	@Column
	private Integer peso;

	@Column
	private String historia;
	
	@Column
	private Boolean estado = true;

	@OneToMany
	private List <Pelicula> listaPeliculas;
	
	public Personaje() {
    }

	public Personaje(String id, Foto foto, String nombre, Integer edad, Integer peso, String historia, Boolean estado,
			List<Pelicula> listaPeliculas) {
		super();
		this.id = id;
		this.foto = foto;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
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
