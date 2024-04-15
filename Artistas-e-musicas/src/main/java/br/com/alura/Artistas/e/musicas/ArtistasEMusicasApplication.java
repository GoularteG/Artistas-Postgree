package br.com.alura.Artistas.e.musicas;

import br.com.alura.Artistas.e.musicas.principal.Principal;
import br.com.alura.Artistas.e.musicas.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtistasEMusicasApplication implements CommandLineRunner {
	@Autowired
	private Repository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ArtistasEMusicasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();

	}
}
