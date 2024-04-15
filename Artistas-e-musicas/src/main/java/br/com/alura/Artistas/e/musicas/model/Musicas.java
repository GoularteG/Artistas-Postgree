package br.com.alura.Artistas.e.musicas.model;

import jakarta.persistence.*;

@Entity
@Table (name = "Musicas")
public class Musicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String titulo;

    @ManyToOne
    private Artista artista;

    public Musicas() {

    }

    public Musicas(String nomeMusica) {
        this.titulo=nomeMusica;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "titulo= " + titulo + '\'' +
                ", artista= " + artista.getNome() ;
    }
}
