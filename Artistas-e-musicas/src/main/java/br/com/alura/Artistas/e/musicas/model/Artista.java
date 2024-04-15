package br.com.alura.Artistas.e.musicas.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;
    @OneToMany(mappedBy ="artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musicas> musicas= new ArrayList<>();

    public Artista(String artista, TipoArtista tipo) {
        this.nome=artista;
        this.tipo=tipo;
    }

    public Artista() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public void setTipo(TipoArtista tipo) {
        this.tipo = tipo;
    }

    public List<Musicas> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musicas> musicas) {
        this.musicas = musicas;
    }


    @Override
    public String toString() {
        return "Nome= " + nome + '\'' +
                ", Tipo= " + tipo +
                ", Musicas= " + musicas;
    }
}
