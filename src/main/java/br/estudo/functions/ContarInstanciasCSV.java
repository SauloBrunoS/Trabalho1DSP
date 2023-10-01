package br.estudo.functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ContarInstanciasCSV {
   
    public static String contarItens() throws Exception {
        int quantidade = 0;
       
        boolean existe = new File("entidade_item.csv").exists();
      
        if (!existe) {
            return "Quantidade de Itens no Arquivo: " + quantidade;
        }
      
        try (BufferedReader reader = new BufferedReader(new FileReader("entidade_item.csv"))) {
            boolean flag = false;
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!flag) {
                    flag = true;
                    continue;
                }
                quantidade++;
            }
            return "Quantidade de Itens no Arquivo: " + quantidade;
        }
        
    }
}
