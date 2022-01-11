package com.Victoria.challengeAlkemy.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column
	private String nombre;

	@Column
	private String usuario;

	@Column
	private String pass;

	@Column
	private String mail;


	@Column
	private Boolean estado;

	@Column
	private String rol = "USER";

	public Usuario() {
	}

	public Usuario(String id, String nombre, String usuario, String pass, String mail) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.pass = pass;
		this.mail = mail;
	
		this.estado = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.id);
		hash = 97 * hash + Objects.hashCode(this.nombre);
		hash = 97 * hash + Objects.hashCode(this.usuario);
		hash = 97 * hash + Objects.hashCode(this.pass);
		hash = 97 * hash + Objects.hashCode(this.mail);	
		hash = 97 * hash + Objects.hashCode(this.estado);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Usuario other = (Usuario) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.nombre, other.nombre)) {
			return false;
		}
		if (!Objects.equals(this.usuario, other.usuario)) {
			return false;
		}
		if (!Objects.equals(this.pass, other.pass)) {
			return false;
		}
		if (!Objects.equals(this.mail, other.mail)) {
			return false;
		}

		if (!Objects.equals(this.estado, other.estado)) {
			return false;
		}
		return true;
	}

}