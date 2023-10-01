package br.estudo.functions;

import java.io.*;
import java.util.zip.*;

public class CompactarCSVParaZIP {
    public static String compactarItemCSVParaZIP() throws Exception {
        boolean existe = new File("entidade_item.csv").exists();
        if (!existe) {
            return "Insira pelo menos uma entidade no csv";
        }
        String arquivoCSV = "entidade_item.csv";
        String arquivoZIP = "entidade_item.zip";

        FileOutputStream fos = new FileOutputStream(arquivoZIP);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        FileInputStream input = new FileInputStream(arquivoCSV);
        
        zipOut.putNextEntry(new ZipEntry(arquivoCSV));
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) > 0) {
            zipOut.write(buffer, 0, bytesRead);
        }
        zipOut.closeEntry();
        zipOut.close();
        input.close();
        return arquivoCSV + " foi compactado para " + arquivoZIP;
    }
}
