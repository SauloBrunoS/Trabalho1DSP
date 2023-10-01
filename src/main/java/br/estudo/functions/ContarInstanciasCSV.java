package br.estudo.functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarInstanciasCSV {
    public static String ContarItens() throws Exception {
        int quantidade = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("entidade_item.csv"))) {
            String lineRead;
            boolean flag = false;
            while ((lineRead = reader.readLine()) != null) {
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
