package br.com.alura.screensound.principal;

import java.util.Scanner;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private int opcao;

    public void exibeMenu(){
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
        
    }

    public void cadastrarMusicas(){
        
    }

    public void listarMusicas(){
        
    }
    
    public void buscarMusicasPorArtista(){
        
    }

    public void pesquisarDadosDoArtista(){
        
    }
}
