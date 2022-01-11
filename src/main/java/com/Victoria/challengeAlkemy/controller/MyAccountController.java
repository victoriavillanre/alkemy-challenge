package com.Victoria.challengeAlkemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Victoria.challengeAlkemy.entity.Personaje;
import com.Victoria.challengeAlkemy.entity.Usuario;
import com.Victoria.challengeAlkemy.service.GeneroService;
import com.Victoria.challengeAlkemy.service.PeliculaService;
import com.Victoria.challengeAlkemy.service.PersonajeService;
import com.Victoria.challengeAlkemy.service.UsuarioService;

@Controller
@RequestMapping("/my-account")
public class MyAccountController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	PersonajeService personajeService;

	@Autowired
	PeliculaService peliculaService;
	
	@Autowired
	GeneroService generoService;
	
	

	// vista inicial del perfil de cada usuario
	@GetMapping("/")
	public String verDatos(Model modelo, @RequestParam(required = false) String error) {
		Usuario usuario = usuarioService.buscarUsuario();
		if (usuario == null) {
			return "redirect:/login";
		}
		if (usuario.getRol().equals("ADMIN")) {
			return "redirect:/admin/";
		}
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("listaPersonajes", PersonajeService.listarPersonajes());
		modelo.addAttribute("nuevoPersonaje", new Personaje());
		modelo.addAttribute("error", error);
		return "myaccount.html";
	}