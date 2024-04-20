package br.com.lista_atividade;

import java.io.*;

public class CopiaArquivoBinario {

    public static void main(String[] args) {
        String srcFile = "arquivo_grande.bin";
        String dstFile = "copia_arquivo_grande.bin";

        try (InputStream in = new FileInputStream(srcFile);
             OutputStream out = new FileOutputStream(dstFile)) {

            byte[] buffer = new byte[8192];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.printf("Arquivo %s copiado para %s com sucesso!%n", srcFile, dstFile);

        } catch (IOException e) {
            System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
        }
    }
}
