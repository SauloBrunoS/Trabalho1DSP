package br.estudo.functions;

import java.io.*;
import java.util.zip.*;

public class CompactarCSVParaZIP {
    public static String compactarItemCSVParaZIP() throws Exception {
        String arquivoCSV = "entidade_item.csv";
        String arquivoZIP = "entidade_item.zip";
        FileOutputStream fos = new FileOutputStream(arquivoZIP);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        FileInputStream fis = new FileInputStream(arquivoCSV);
        zipOut.putNextEntry(new ZipEntry(arquivoCSV));
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) > 0) {
            zipOut.write(buffer, 0, bytesRead);
        }
        zipOut.closeEntry();
        zipOut.close();
        fis.close();
        return arquivoCSV + " foi compactado para " + arquivoZIP;
    }
}
