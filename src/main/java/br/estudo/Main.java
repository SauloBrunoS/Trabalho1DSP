package br.estudo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.estudo.functions.CompactarCSVParaZIP;
import br.estudo.functions.ContarInstanciasCSV;
import br.estudo.functions.InserirNoCSV;
import br.estudo.model.Item;
import br.estudo.model.ListaItens;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Menu:");
                System.out.println("(1). Inserir entidade no arquivo CSV");
                System.out.println("(2). Mostrar quantidade de entidades no arquivo CSV");
                System.out.println("(3). Converter dados do arquivo CSV para JSON e XML");
                System.out.println("(4). Compactar arquivo CSV em ZIP");
                System.out.println("(5). Mostrar hash SHA256 do arquivo CSV");
                System.out.println("(6). Sair");

                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        String resultadoInserirItemCSV = InserirNoCSV.inserirItem();
                        System.out.println(resultadoInserirItemCSV);
                        break;
                    case 2:
                        String resultadoContarInstanciasItemCSV = ContarInstanciasCSV.ContarItens();
                        System.out.println(resultadoContarInstanciasItemCSV);
                        break;
                    // case 3:
                    // converterCSVparaJSONeXML();
                    // break;
                    case 4:
                        String resultadoCompactarItemCSVParaZIP = CompactarCSVParaZIP.compactarItemCSVParaZIP();
                        System.out.println(resultadoCompactarItemCSVParaZIP);
                        break;
                    // case 5:
                    // mostrarHashSHA256doCSV();
                    // break;
                    case 6:
                        System.out.println("Saindo...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (Exception e) {
            System.err.println("Erro:" + e.getMessage());
        }
    }
}
