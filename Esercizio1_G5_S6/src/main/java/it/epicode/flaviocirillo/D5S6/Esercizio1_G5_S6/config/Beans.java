package it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.Dispositivo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.Ruolo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.StatoDispositivo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.TipoDispositivo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.TipoRuolo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.Utente;

@Configuration
public class Beans {

	@Bean
	@Scope("prototype")
	public Utente utente(String nome, String cognome, String email, String password, String username) {
		return Utente.builder()
				.nome(nome)
				.cognome(cognome)
				.email(email)
				.username(username)
				.password(password)
				.active(true)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Dispositivo dispositivo(TipoDispositivo td, StatoDispositivo sd) {
		return Dispositivo.builder()
				.tipoDispositivo(td)
				.stato(sd)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Ruolo ruolo(TipoRuolo rt) {
		return Ruolo.builder()
				.tipoRuolo(rt)
				.build();
	}
	
}
