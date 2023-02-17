package it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.config.Beans;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.Dispositivo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.Ruolo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.StatoDispositivo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.TipoDispositivo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.TipoRuolo;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.entities.Utente;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.services.DispositivoService;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.services.RuoloService;
import it.epicode.flaviocirillo.D5S6.Esercizio1_G5_S6.services.UtenteService;

@SpringBootApplication
public class Esercizio1G5S6Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Esercizio1G5S6Application.class, args);
	}
	
	@Autowired
	private UtenteService us;
	
	@Autowired
	private DispositivoService ds;
	
	@Autowired
	private RuoloService rs;
	
	@Value("${popola_db}")
	private int popolaDbFlag;

	@Override
	public void run(String... args) throws Exception {
		
		if( popolaDbFlag == 1 ) {
			popolaDb();
			System.out.println("DB generato");
		}
		
		getRolesFromUserById(1);
		
	}
	
	private void popolaDb() {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		
		Utente u1 = (Utente)ctx.getBean("utente", "Flavio", "Cirillo", "flavio@cirillo.com", "test1", "fcirillo");
		Utente u2 = (Utente)ctx.getBean("utente", "Mario", "Rossi", "mario@rossi.com", "test2", "mrossi");
		
		Ruolo r1 = (Ruolo)ctx.getBean("ruolo", TipoRuolo.ROLE_ADMIN);
		Ruolo r2 = (Ruolo)ctx.getBean("ruolo", TipoRuolo.ROLE_USER);
		
		u1.setRuoli(new HashSet<>() {{
			add(r1);
		}});
		
		u2.setRuoli(new HashSet<>() {{
			add(r2);
		}});
		
		Dispositivo d1 = (Dispositivo)ctx.getBean("dispositivo", TipoDispositivo.SMARTPHONE, StatoDispositivo.ASSEGNATO);
		Dispositivo d2 = (Dispositivo)ctx.getBean("dispositivo", TipoDispositivo.LAPTOP, StatoDispositivo.DISPONIBILE);
		Dispositivo d3 = (Dispositivo)ctx.getBean("dispositivo", TipoDispositivo.TABLET, StatoDispositivo.IN_MANUTENZIONE);
		
		u2.setDispositivo(new HashSet<>() {{
			add(d1);
		}});
		
		rs.save(r1);
		rs.save(r2);
		
		ds.save(d1);
		ds.save(d2);
		ds.save(d3);
		
		us.save(u1);
		us.save(u2);
		
		((AnnotationConfigApplicationContext)ctx).close();
		
	}
	
	private void getRolesFromUserById(int id) {
		Optional<Utente> authUserObj = us.getById(id);
		Utente authUser = authUserObj.get();
		String ruolo  = "USER";
		Set<Ruolo> ruoli = authUser.getRuoli();
		for(Ruolo r : ruoli) {
			if(r.getTipoRuolo().toString().contains("ADMIN")) {
				ruolo = "ADMIN";
				break;
			}
		}
		
		System.out.println(ruolo);
	}

}
