import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MetodosOrdenamiento extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;

    public OrdenamientoGUI() {
        setTitle("Métodos de Ordenamiento");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior: entrada de datos
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Ingrese los números separados por comas:"));
        inputField = new JTextField(25);
        topPanel.add(inputField);
        add(topPanel, BorderLayout.NORTH);

        // Panel central: resultados
        outputArea = new JTextArea(8, 40);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Panel inferior: botones de ordenamiento
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton burbujaBtn = new JButton("Burbuja");
        JButton insercionBtn = new JButton("Inserción");
        JButton quicksortBtn = new JButton("Quicksort");

        buttonPanel.add(burbujaBtn);
        buttonPanel.add(insercionBtn);
        buttonPanel.add(quicksortBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Listeners
        burbujaBtn.addActionListener(e -> ordenar("burbuja"));
        insercionBtn.addActionListener(e -> ordenar("insercion"));
        quicksortBtn.addActionListener(e -> ordenar("quicksort"));
    }

    private void ordenar(String metodo) {
        String texto = inputField.getText();
        if (texto.isEmpty()) {
            outputArea.setText("Por favor ingrese números primero.");
            return;
        }

        try {
            String[] partes = texto.split(",");
            int[] arreglo = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                arreglo[i] = Integer.parseInt(partes[i].trim());
            }

            int[] copia = arreglo.clone();

            switch (metodo) {
                case "burbuja":
                    burbuja(copia);
                    outputArea.setText("Ordenado con Burbuja:\n" + mostrar(copia));
                    break;
                case "insercion":
                    insercion(copia);
                    outputArea.setText("Ordenado con Inserción:\n" + mostrar(copia));
                    break;
                case "quicksort":
                    quicksort(copia, 0, copia.length - 1);
                    outputArea.setText("Ordenado con Quicksort:\n" + mostrar(copia));
                    break;
            }

        } catch (NumberFormatException ex) {
            outputArea.setText("Error: asegúrate de ingresar solo números separados por comas.");
        }
    }

    private String mostrar(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        return sb.toString();
    }

    // Métodos de ordenamiento
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
            n--;
        } while (cambio);
    }

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OrdenamientoGUI().setVisible(true);
        });
    }
}

