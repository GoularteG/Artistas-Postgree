package br.com.alura.Artistas.e.musicas.repository;

import br.com.alura.Artistas.e.musicas.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArt);
}
