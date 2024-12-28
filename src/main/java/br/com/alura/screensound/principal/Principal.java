package br.com.alura.screensound.principal;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.model.Musica;
import br.com.alura.screensound.model.TipoArtista;
import br.com.alura.screensound.repository.ArtistaRepository;
import br.com.alura.screensound.service.ConsultaChatGPT;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private ArtistaRepository repositorio;        
    public Principal(ArtistaRepository repositorio){
        this.repositorio = repositorio;
    }
    
    
    public void exibeMenu(){
        var opcao = 0;
        do {
            var menu = """
                *** Screen Sound Músicas ***                    
                                    
                1- Cadastrar artistas
                2- Cadastrar músicas
                3- Listar músicas
                4- Buscar músicas por artistas
                5- Pesquisar dados sobre um artista
                                
                9 - Sair
                """;

            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            
            }
        }while (opcao != 9);             
        
    }

    public void cadastrarArtistas(){
        var cadastrarNovo = "S";
        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.print("Insira o nome do artista: ");
            var nome = sc.nextLine();
            System.out.print("Insira o tipo desse artista: (Solo/Dupla/Banda): ");
            var tipo = sc.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);
            repositorio.save(artista);
            System.out.print("Cadastrar novo artista? Insira (S/N): ");
            cadastrarNovo = sc.nextLine();
        }        
    }

    public void cadastrarMusicas(){
        System.out.print("Cadastrar música de qual artista? ");
        var nome = sc.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if (artista.isPresent()) {
            System.out.print("Informe o título da música: ");
            var nomeMusica = sc.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista não encontrado");
        }
    }

    public void listarMusicas(){
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }
    
    public void buscarMusicasPorArtista(){
        System.out.print("Buscar músicas de qual artista: ");
        var nome = sc.nextLine();
        List<Musica> musicas = repositorio.buscaMusicasPorArtista(nome);
        musicas.forEach(System.out::println);
    }

    public void pesquisarDadosDoArtista(){
        System.out.print("Pesquisar Dados sobre qual artista? ");
        var nome = sc.nextLine();
        var reposta = ConsultaChatGPT.obterInformacao(nome);
        System.out.println(reposta.trim());
    }
}
