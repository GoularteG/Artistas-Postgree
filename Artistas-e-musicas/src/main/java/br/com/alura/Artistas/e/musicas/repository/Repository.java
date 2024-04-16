package br.com.alura.Artistas.e.musicas.repository;

import br.com.alura.Artistas.e.musicas.model.Artista;
import br.com.alura.Artistas.e.musicas.model.Musicas;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArt);
    @Query("SELECT m FROM Artista a JOIN  a.musicas m WHERE a.nome ILIKE %:nome%")
    List<Musicas> buscaMusicasPorArtistas(String nome);
}
