package it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {
	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "<h2>ti trovi sulla home page</h2> <br> se sei ADMIN scrivi /utenti, /dispositivi, /ruoli per visitare il sito!";
	}

	@PostMapping("/login_success")
	@ResponseBody
	public String login_success() {
		return "<h2>login eseguito con successo</h2>";
	}	
	
}
