import java.util.Scanner;

public class MetodosOrdenamiento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arreglo = {5, 3, 8, 4, 2, 7, 1, 10, 6, 9};
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE ORDENAMIENTO ---");
            System.out.println("1. Método Burbuja");
            System.out.println("2. Método Inserción (Secuencial)");
            System.out.println("3. Método Quicksort");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            int[] copia = arreglo.clone(); // Clonar arreglo original para no modificarlo permanentemente

            switch (opcion) {
                case 1:
                    burbuja(copia);
                    System.out.print("Ordenado con Burbuja: ");
                    imprimir(copia);
                    break;
                case 2:
                    insercion(copia);
                    System.out.print("Ordenado con Inserción: ");
                    imprimir(copia);
                    break;
                case 3:
                    quicksort(copia, 0, copia.length - 1);
                    System.out.print("Ordenado con Quicksort: ");
                    imprimir(copia);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        scanner.close();
    }

    // Método Burbuja
    public static void burbuja(int[] arr) {
        int n = arr.length;
        boolean cambio;
        do {
            cambio = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    cambio = true;
                }
            }
            n--; // Optimización
        } while (cambio);
    }

    // Método Inserción (Secuencial)
    public static void insercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int actual = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > actual) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = actual;
        }
    }

    // Método Quicksort
    public static void quicksort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particion(arr, izquierda, derecha);
            quicksort(arr, izquierda, indicePivote - 1);
            quicksort(arr, indicePivote + 1, derecha);
        }
    }

    public static int particion(int[] arr, int izquierda, int derecha) {
        int pivote = arr[derecha];
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[derecha];
        arr[derecha] = temp;
        return i + 1;
    }

    // Método para imprimir el arreglo
    public static void imprimir(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
