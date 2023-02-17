package it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.Ruolo;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Integer> {

}
