package com.Victoria.challengeAlkemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Victoria.challengeAlkemy.service.GeneroService;
import com.Victoria.challengeAlkemy.service.PeliculaService;
import com.Victoria.challengeAlkemy.service.PersonajeService;



@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	PersonajeService personajeService;

	@Autowired
	PeliculaService peliculaService;
	
	@Autowired
	GeneroService generoService;

	@GetMapping({ "/", "/index" })
	public String index(Model modelo) {
		modelo.addAttribute("listaPersonajes", personajeService.listarPersonajesActivos());
		return "index.html";
	}

	@GetMapping("/login")
	public String login(Model model, @RequestParam(required = false) String error,
			@RequestParam(required = false) String usuario) {
		if (error != null) {
			model.addAttribute("error", "El usuario ingresado o la contraseña no son válidos.");
		}
		if (usuario != null) {
			model.addAttribute("usuario", usuario);
		}
		return "login.html";
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("success", "Ha finalizado su sesión exitosamente.");
		SecurityContextHolder.clearContext();
		return "login";
	}
}
