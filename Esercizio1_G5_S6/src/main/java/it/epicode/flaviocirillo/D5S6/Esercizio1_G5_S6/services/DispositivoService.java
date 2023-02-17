package it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.Dispositivo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.repositories.DispositivoRepository;

@Service
public class DispositivoService {

	@Autowired
	private DispositivoRepository disRepo;
	
	public Dispositivo save(Dispositivo d) {
		return disRepo.save(d);
	}
	
	public List<Dispositivo> getAll() {
		return disRepo.findAll();
	}
	
	public Optional<Dispositivo> getById(int id) {
		return disRepo.findById(id);
	}
	
	public Page<Dispositivo> getAll_page(Pageable pageable) {
		return disRepo.findAll(pageable);
	}
	
	public void delete(Dispositivo d) {
		disRepo.delete(d);
	}
	
}
