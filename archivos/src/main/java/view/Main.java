package view;

import model.Client;
import model.Pet;
import model.PrimitiveSort;
import model.Vet;

import java.time.LocalDate;

public class Main {

    public static PrimitiveSort po = new PrimitiveSort();

    public static void main(String[] args) {
        try {
            Vet vet = new Vet();
            /*vet.loadClients("C:\\Users\\38668150\\OneDrive - Universidad Icesi\\2025-1\\APO2\\Projects\\archivos\\src\\main\\java\\data\\clients.txt");
            vet.addClient();
            vet.saveClients("C:\\Users\\38668150\\OneDrive - Universidad Icesi\\2025-1\\APO2\\Projects\\archivos\\src\\main\\java\\data\\clients.txt");
*/
            //JSon
            vet.loadJson();
            vet.addClient(new Client("Ana", "1023456", "3001234567", LocalDate.of(1995, 5, 20)));
            vet.saveJson();
            vet.addPet(new Pet("Lulú"));
            vet.addPet(new Pet("Firulais"));
            vet.addPet(new Pet("tavita"));

            //vet.showSortedPets();
            //vet.showSortedClientsByBirthDate();
           //vet.showSortedClientsById();
            vet.showSortedClientsByBirthDateThenId();


        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // Primitive Sort
    public static void primitiveSort() {
        // int[] arr = po.selectionSort();
        //int[] arr = po.insertionSort();
        int[] arr = po.burbleSort();
        System.out.println("Arreglo ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}