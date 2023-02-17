package it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Utente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String password;
	
	private boolean active;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "ruoli_utente",
			joinColumns = @JoinColumn(name = "utente_id"),
			inverseJoinColumns = @JoinColumn(name = "ruolo_id")
	)
	private Set<Ruolo> ruoli = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "dispositivi_utente",
			joinColumns = @JoinColumn(name = "utente_id"),
			inverseJoinColumns = @JoinColumn(name = "dispositivo_id")
	)
	private Set<Dispositivo> dispositivo = new HashSet<>();
	
}
