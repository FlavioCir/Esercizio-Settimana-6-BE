package it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.Utente;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.repositories.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepo;
	
	public Utente save(Utente u) {
		return utenteRepo.save(u);
	}
	
	public List<Utente> getAll() {
		return utenteRepo.findAll();
	}
	
	public Optional<Utente> getById(int id) {
		return utenteRepo.findById(id);
	}
	
	public Page<Utente> getAll_page(Pageable pageable) {
		return utenteRepo.findAll(pageable);
	}
	
	public void delete(Utente u) {
		utenteRepo.delete(u);
	}
	
}
