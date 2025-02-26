package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Vet {
    private ArrayList<Client>  clients;
    private File data;
    private Path dataFolder;
    private Path dataJson;

    public Vet(){
        clients = new ArrayList<>();
        /*File projectDir = new File(System.getProperty("user.dir"));
        data = new File(projectDir+"/src/main/data");*/
        Path dataProject = Paths.get(System.getProperty("user.dir"));
        dataFolder = dataProject.resolve(dataProject+"/src/main/java/data");
        dataJson = dataFolder.resolve("clients.json");

        data = new File("clients.txt");

    }
    public void loadClients(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 3) {
                    clients.add(new Client(datos[0], datos[1], datos[2]));
                }
            }
            System.out.println("Clientes cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void saveClients(String file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Client client : clients) {
                bw.write(client.toString());
                bw.newLine();
            }
            System.out.println("Clientes guardados en " + file);

    }

    public void loadJson() {
        try {
            String jsonData = Files.readString(dataJson);
            Gson gson = new Gson();
            Type list = new TypeToken<ArrayList<Client>>(){}.getType();
            clients = gson.fromJson(jsonData, list);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }

    public void saveJson() {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(clients);
            Files.writeString(dataJson,json);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
        }
    }
    public void addClient() {
        clients.add(new Client("lorena jojoa", "12345", "567849"));
    }
}
