//Clase principal 
public class GestionClientes {
  public static void main(String[] args) {
      java.util.Scanner scanner = new java.util.Scanner(System.in);
      ListaDobleClientes lista = new ListaDobleClientes();
      int opcion;
      
      do {
          // Menu de opciones
          System.out.println("\n==SISTEMA DE GESTION DE CLIENTES==");
          System.out.println("1. Insertar cliente");
          System.out.println("2. Listar clientes hacia la derecha");
          System.out.println("3. Listar clientes hacia la izquierda");
          System.out.println("4. Salir");
          System.out.print("Seleccione una opcion: ");
          
          try {
              opcion = Integer.parseInt(scanner.nextLine());
              
              switch (opcion) {
                  case 1:
                      // Opcion para insertar cliente
                      System.out.print("Ingrese la cedula del cliente: ");
                      String cedula = scanner.nextLine();
                      System.out.print("Ingrese el nombre del cliente: ");
                      String nombre = scanner.nextLine();
                      
                      Cliente nuevoCliente = new Cliente(cedula, nombre);
                      lista.insertarOrdenado(nuevoCliente);
                      break;
                  case 2:
                      // Opcion para listar clientes de primero al ultimo
                      lista.listarClientesDerecha();
                      break;
                  case 3:
                      // Opcion para listar clientes de ultimo a primero
                      lista.listarClientesIzquierda();
                      break;
                  case 4:
                      // Opcion para salir
                      System.out.println("Gracias por usar el sistema.");
                      break;  
                  default:
                      System.out.println("Opcion no valida. Intente nuevamente.");
              }
          } catch (NumberFormatException e) {
              System.out.println("Error: Debe ingresar un numero valido.");
              opcion = 0;
          }
      } while (opcion != 4);
      scanner.close();
  }
}