package br.estudo.functions;

import java.io.*;
import java.security.MessageDigest;

public class CalcularHashSHA256CSV {
    public static String calcularHashSHA256ItemCSV() throws Exception {
        String arquivoCSV = "entidade_item.csv";
        FileInputStream fis = new FileInputStream(arquivoCSV);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            digest.update(buffer, 0, bytesRead);
        }
        byte[] hash = digest.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        fis.close();
        return "Hash SHA-256 do arquivo " + arquivoCSV + ": " + hexString.toString();
    }
}
