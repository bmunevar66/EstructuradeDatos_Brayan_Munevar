import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OrdenamientoGUI extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;

    public OrdenamientoGUI() {
        setTitle("Métodos de Ordenamiento");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior: entrada de datos
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBorder(new EmptyBorder(10, 10, 0, 10)); // margen superior
        topPanel.add(new JLabel("Ingrese los números separados por comas:"));
        inputField = new JTextField(30);
        topPanel.add(inputField);
        add(topPanel, BorderLayout.NORTH);

        // Área central: resultados
        outputArea = new JTextArea(15, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Panel inferior: botones
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
            StringBuilder log = new StringBuilder();

            switch (metodo) {
                case "burbuja":
                    log.append("Proceso del método Burbuja:\n");
                    burbuja(copia, log);
                    break;
                case "insercion":
                    log.append("Proceso del método Inserción:\n");
                    insercion(copia, log);
                    break;
                case "quicksort":
                    log.append("Proceso del método Quicksort:\n");
                    quicksort(copia, 0, copia.length - 1, log, 1);
                    break;
            }

            log.append("\nResultado final:\n").append(arrayToString(copia));
            outputArea.setText(log.toString());

        } catch (NumberFormatException ex) {
            outputArea.setText("Error: asegúrate de ingresar solo números separados por comas.");
        }
    }

    // Métodos de ordenamiento con proceso
    public static void burbuja(int[] arr, StringBuilder log) {
        int n = arr.length;
        boolean cambio;
        int paso = 1;
        do {
            cambio = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    log.append("Paso ").append(paso++).append(": ")
                       .append(arrayToString(arr)).append("\n");
                    cambio = true;
                }
            }
            n--;
        } while (cambio);
    }

    public static void insercion(int[] arr, StringBuilder log) {
        int paso = 1;
        for (int i = 1; i < arr.length; i++) {
            int actual = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > actual) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = actual;
            log.append("Paso ").append(paso++).append(": ")
               .append(arrayToString(arr)).append("\n");
        }
    }

    public static void quicksort(int[] arr, int izquierda, int derecha, StringBuilder log, int nivel) {
        if (izquierda < derecha) {
            int indicePivote = particion(arr, izquierda, derecha, log, nivel);
            quicksort(arr, izquierda, indicePivote - 1, log, nivel + 1);
            quicksort(arr, indicePivote + 1, derecha, log, nivel + 1);
        }
    }

    public static int particion(int[] arr, int izquierda, int derecha, StringBuilder log, int nivel) {
        int pivote = arr[derecha];
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                log.append("Nivel ").append(nivel).append(" - intercambio: ")
                   .append(arrayToString(arr)).append("\n");
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[derecha];
        arr[derecha] = temp;
        log.append("Nivel ").append(nivel).append(" - pivote colocado: ")
           .append(arrayToString(arr)).append("\n");
        return i + 1;
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrdenamientoGUI().setVisible(true));
    }
}
