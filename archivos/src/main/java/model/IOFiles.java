package model;
import java.io.*;
public class IOFiles {

    public void readFile(){
        String archivoEntrada = "entrada.txt";
        String archivoSalida = "salida.txt";

        try (FileReader lector = new FileReader(archivoEntrada);
             FileWriter escritor = new FileWriter(archivoSalida)) {

            int c;
            while ((c = lector.read()) != -1) { // Lee caracter por caracter
                escritor.write(c); // Escribe en el archivo de salida
            }

            System.out.println("Archivo copiado correctamente con java.io");

        } catch (IOException e) {
            System.out.println("Error al manejar archivos: " + e.getMessage());
        }
    }
}
