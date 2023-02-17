package it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.Ruolo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.repositories.RuoloRepository;

@Service
public class RuoloService {

	@Autowired
	private RuoloRepository ruoloRepo;
	
	public Ruolo save(Ruolo r) {
		return ruoloRepo.save(r);
	}
	
	public List<Ruolo> getAll() {
		return ruoloRepo.findAll();
	}
	
	public Optional<Ruolo> getById(int id) {
		return ruoloRepo.findById(id);
	}
	
	public Page<Ruolo> getAll_page(Pageable pageable) {
		return ruoloRepo.findAll(pageable);
	}
	
	public void delete(Ruolo r) {
		ruoloRepo.delete(r);
	}
	
}
