package br.estudo.functions;

import java.io.FileOutputStream;
import java.io.FileReader;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.CSVReader;

public class ConverterCSVtoJSONeXML {
    public ConverterCSVtoJSONeXML(){}

    public static List<String[]> lerCSV(String nomeCSV) throws Exception{
        try(CSVReader reader = new CSVReader(new FileReader(nomeCSV))){
            return reader.readAll();
        }
    }

    public static String converterJSON(List<String[]> dataCSV, String nomeCSV) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
       
        FileOutputStream out = new FileOutputStream("entidade_item.json");

        mapper.writeValue(out, dataCSV); out.close();

       return "A conversão de CSV para JSON foi concluida com Sucesso.";
    }


    public static String converterXML(List<String[]> dataCSV, String nomeCSV) throws Exception{
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        FileOutputStream out = new FileOutputStream("entidade_item.xml");

        mapper.writeValue(out, dataCSV); out.close();


        
        return "A conversão de CSV para XML foi concluida com Sucesso.";
    }

}
