package view;

import model.Vet;

public class Main {
    public static void main(String[] args) {
        try {
            Vet vet = new Vet();
            /*vet.loadClients("C:\\Users\\38668150\\OneDrive - Universidad Icesi\\2025-1\\APO2\\Projects\\archivos\\src\\main\\java\\data\\clients.txt");
            vet.addClient();
            vet.saveClients("C:\\Users\\38668150\\OneDrive - Universidad Icesi\\2025-1\\APO2\\Projects\\archivos\\src\\main\\java\\data\\clients.txt");
*/
            //JSon
            vet.loadJson();
            vet.addClient();
            vet.saveJson();


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}