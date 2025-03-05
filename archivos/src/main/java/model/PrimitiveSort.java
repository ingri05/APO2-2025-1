package model;


public class PrimitiveSort {


    int[] datos;


    public PrimitiveSort() {
        datos = new int[]{64, 25, 12, 22, 11, 9, 42, 54, 99, 10};


    }


    //SelectionSort
    public int[] selectionSort() {
        for (int i = 0; i < datos.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < datos.length; j++) {
                if (datos[j] < datos[minIndex]) {
                    minIndex = j;
                }
            }
            // Intercambiar el valor mínimo encontrado con el valor en la posición i
            int temp = datos[minIndex];
            datos[minIndex] = datos[i];
            datos[i] = temp;
        }
        return datos;
    }


    //InsertionSort
    public int[] insertionSort() {
        int n = datos.length;
        for (int i = 1; i < n; i++) {
            int key = datos[i];
            int j = i - 1;


            // Mover los elementos de datos[0..i-1] que son mayores que la clave
            // a una posición adelante de su posición actual
            while (j >= 0 && datos[j] > key) {
                datos[j + 1] = datos[j];
                j = j - 1;
            }
            datos[j + 1] = key;
        }
        return datos;
    }


    //Burble sort
    public int[] burbleSort() {
        for (int i = 0; i < datos.length - 1; i++) {
            for (int j = 0; j < datos.length - i - 1; j++) {
                if (datos[j] > datos[j + 1]) {
                    // Intercambiar los elementos
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }
            }
        }
        return datos;
    }
}

