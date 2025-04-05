//Clase principal 
public class GestionClientes{
public static void main(String[] args){
java.util.Scanner scanner = new java.util.Scanner(System.in);
ListaClientes lista = new ListaClientes();
int opcion;

//Menu de opciones
do{
System.out.println("Sistema de Clientes ");
System.out.println("1. Añadir Cliente");
System.out.println("2. Lista de Clientes");
System.out.println("3. Salir");

{
  opcion = Interger.parseInt(scanner.nextLine());
    switch (opcion) {
      case 1: //Opcion de insertar cliente
        System.out.print("Digite la Cedula del cliente: ");
        String cedula=scanner.nextLine();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre=scanner.nextLine();

  Clientes nuevoCliente = new Clientes(cedula,nombre);
    lista.insertarOrden(nuevoCliente);
    break;
      case 2: //Opcion mostrar lista clientes
        lista.listarClientes();
    break;
      case 3: // opcion salir
        System.out.println("Se cerro el programa");
    break;
    default;
        System.out.println(Opcion no valida. Intente de nuevo");
          }
        }
    }while (opcion !=3);
      scanner.close();
  }
}
