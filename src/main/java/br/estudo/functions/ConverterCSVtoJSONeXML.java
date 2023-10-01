package br.estudo.functions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.CSVReader;

import br.estudo.model.Item;
import br.estudo.model.ListaItens;

public class ConverterCSVtoJSONeXML {
    public static List<String[]> lerCSVItem() throws Exception {
        boolean existe = new File("entidade_item.csv").exists();
        if (!existe)
            return null;
        try (CSVReader reader = new CSVReader(new FileReader("entidade_item.csv"))) {
            return reader.readAll();
        }
    }

    public static List<Item> converterParaListaItens(List<String[]> data) {
        List<Item> itemList = new ArrayList<>();
        if (data != null) {
            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                if (row.length >= 6) {
                    int id = Integer.parseInt(row[0]);
                    String nome = row[1];
                    String descricao_item = row[2];
                    Item.Categoria categoria_item = Item.Categoria.valueOf(row[3]);
                    int quantidade = Integer.parseInt(row[4]);
                    Number valor = Double.parseDouble(row[5]);
                    Item item = new Item(id, nome, descricao_item, categoria_item, quantidade, valor);
                    itemList.add(item);
                }
            }
            return itemList;
        }
        return null;
    }

    public static String converterJSONItemCSV(ListaItens dataCSV) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        FileOutputStream out = new FileOutputStream("entidade_item.json");

        mapper.writeValue(out, dataCSV);
        out.close();

        return "A conversão de CSV para JSON foi concluida com Sucesso.";
    }

    public static String converterXMLItemCSV(ListaItens dataCSV) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        FileOutputStream out = new FileOutputStream("entidade_item.xml");

        mapper.writeValue(out, dataCSV);
        out.close();

        return "A conversão de CSV para XML foi concluida com Sucesso.";
    }
}
