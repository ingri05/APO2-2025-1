package model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NIOFiles {

    public void readFile(){
        Path origen = Paths.get("entrada.txt");
        Path destino = Paths.get("salida.txt");

        try {
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado correctamente con java.nio");
        } catch (Exception e) {
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
    }

}
