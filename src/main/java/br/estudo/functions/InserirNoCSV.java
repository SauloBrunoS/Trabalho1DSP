package br.estudo.functions;

import java.io.File;
import java.io.FileWriter;

import com.opencsv.CSVWriter;

import br.estudo.model.Item;
import br.estudo.readEntity.LerItem;

public class InserirNoCSV {
    public static String inserirItem() throws Exception {
        LerItem itemLido = new LerItem();
        Item item = itemLido.lerItem();
        boolean existe = new File("entidade_item.csv").exists();
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("entidade_item.csv", true))) {
            if (!existe) {
                String[] header = { "id", "nome", "descricao", "categoria", "quantidade", "valor" };
                csvWriter.writeNext(header);
            }
            String[] dados = itemLido.dadosItem(item);
            csvWriter.writeNext(dados);
            return "Item Escrito com Sucesso";
        }
    }
}
