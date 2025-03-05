package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Vet {
    private ArrayList<Client>  clients;
    private List<Pet> pets ;
    private File data;
    private Path dataFolder;
    private Path dataJson;

    public Vet(){
        clients = new ArrayList<>();
        pets = new ArrayList<>();
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
                addClient(new Client(datos[0], datos[1], datos[2], LocalDate.parse(datos[3])));

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
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) // Registrar el adaptador
                    .create();
            Type list = new TypeToken<ArrayList<Client>>(){}.getType();
            clients = gson.fromJson(jsonData, list);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }

    public void saveJson() {
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) // Registrar el adaptador
                    .create();
            String json = gson.toJson(clients);
            Files.writeString(dataJson,json);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
        }
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void showSortedPets() {
        Collections.sort(pets);
        System.out.println("Mascotas ordenadas por nombre: " + pets);
    }

    public void showSortedClientsByBirthDate() {
        Comparator<Client> cl = new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return c1.getBirthDate().compareTo(c2.getBirthDate());
            }
        };

        clients.sort(cl);
        System.out.println("Clientes ordenados por fecha de nacimiento: "+clients);
    }

    public void showSortedClientsById() {
        clients.sort(new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                return c1.getId().compareTo(c2.getId());
            }
        });
        System.out.println("Clientes ordenados por cédula: " + clients);
    }

    public void showSortedClientsByBirthDateThenId() {
        clients.sort(new Comparator<Client>() {
            @Override
            public int compare(Client c1, Client c2) {
                int result = c1.getBirthDate().compareTo(c2.getBirthDate());
                if (result == 0) {
                    return c1.getId().compareTo(c2.getId());
                }
                return result;
            }
        });
        System.out.println("Clientes ordenados por fecha de nacimiento y luego cédula: " + clients);
    }
}
