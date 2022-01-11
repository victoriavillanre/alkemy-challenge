package com.Victoria.challengeAlkemy.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Pelicula implements Serializable {

	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	
	@OneToOne
    private Foto foto;
	
	@Column
	private String titulo;

	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	@Column
	private Integer calificacion; /*del 1 al 5*/

	@Column
	private String historia;
	
	@Column
	private Boolean estado = true;

	@OneToMany
	private List <Personaje> listaPersonajes; /*personajes asociados*/

	
    public Pelicula() {
	    }
	    
	
	public Pelicula(String id, Foto foto, String titulo, Date fechaCreacion, Integer calificacion, String historia,
			Boolean estado, List<Personaje> listaPersonajes) {
		super();
		this.id = id;
		this.foto = foto;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.historia = historia;
		this.estado = estado;
		this.listaPersonajes = listaPersonajes;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
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

	public List<Personaje> getListaPersonajes() {
		return listaPersonajes;
	}

	public void setListaPersonajes(List<Personaje> listaPersonajes) {
		this.listaPersonajes = listaPersonajes;
	}
	

	
}
