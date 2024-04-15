package br.com.alura.Artistas.e.musicas.principal;

import br.com.alura.Artistas.e.musicas.model.Artista;
import br.com.alura.Artistas.e.musicas.model.Musicas;
import br.com.alura.Artistas.e.musicas.model.TipoArtista;
import br.com.alura.Artistas.e.musicas.repository.Repository;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final Repository repositorio;
    Scanner ler = new Scanner(System.in);

    public Principal(Repository repositorio) {
        this.repositorio=repositorio;
    }

    public void  exibeMenu(){
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    ===== Artistas e Músicas =====                    
                                        
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                                    
                    0 - Sair
                    """);
            opcao = ler.nextInt();
            ler.nextLine();
            switch (opcao){
                case 1:
                    cadastroArtistas();
                    break;
                case 2:
                    cadastroMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    pesquisarDadosSobreUmArtista();
                    break;
                case 0:
                    break;

            }
        }
    }

    private void cadastroArtistas() {
        var novo= "s";

        while (novo.equalsIgnoreCase("s")) {
            System.out.println("Qual o nome desse artista? ");
            String artista = ler.nextLine();
            System.out.println("Informe o tipo desse artista? (solo/dupla/banda)");
            String tipo = ler.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista a = new Artista(artista, tipoArtista);
            repositorio.save(a);
            System.out.println("Cadastrar novo artista? (s/n)");
            novo = ler.nextLine();
        }
    }

    private void cadastroMusica() {
        System.out.println("Cadastrar musica de que artista?");
        String nomeArt= ler.nextLine();
        Optional<Artista> artista= repositorio.findByNomeContainingIgnoreCase(nomeArt);
       if (artista.isPresent()) {
           System.out.println("Digite o nome da musica:  ");
           var nomeMusica= ler.nextLine();
           Musicas musica = new Musicas(nomeMusica);
           musica.setArtista(artista.get());
           artista.get().getMusicas().add(musica);
           repositorio.save(artista.get());
       }else {
           System.out.println("Artista não encontrado!");
       }
    }


    private void listarMusicas() {
        List<Artista> artistas= repositorio.findAll();
        artistas.forEach(System.out::println);
    }

    private void buscarMusicaPorArtista() {
    }

    private void pesquisarDadosSobreUmArtista() {
    }

}
