// Clase que implementa la lista simple
class ListaClientes1 {
    private Nodo1 primero;  // Puntero al primer nodo de la lista
    private int tamaño;   // Contador de elementos en la lista
    
    //Constructor de la lista simple
    public ListaClientes1() {
        this.primero = null;
        this.tamaño = 0;
    }
    
    //Verifica si la lista esta vacia
    //true si la lista esta vacia, false en caso contrario
    public boolean estaVacia() {
        return primero == null;
    }
    //Obtiene el tamaño actual de la lista
    //return Numero de elementos en la lista
    public int getTamaño() {
        return tamaño;
    }
    //Inserta un nuevo cliente en la lista de forma ordenada por cedula
    public void insertarOrden(Clientes cliente) {
        Nodo1 nuevoNodo = new Nodo1(cliente);
        
        // Si la lista esta vacia o el nuevo cliente debe ir al principio
        if (estaVacia() || cliente.getCedula().compareTo(primero.getCliente().getCedula()) < 0) {
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
        } else {
            // Buscar la posicion correcta para insertar
            Nodo1 actual = primero;
            Nodo1 anterior = null;
            
            while (actual != null && cliente.getCedula().compareTo(actual.getCliente().getCedula()) > 0) {
                anterior = actual;
                actual = actual.getSiguiente();
            }
            
            // Verificar si el cliente ya existe
            if (actual != null && cliente.getCedula().equals(actual.getCliente().getCedula())) {
                System.out.println("Error: El cliente con cedula " + cliente.getCedula() + " ya existe.");
                return;
            }
            
            // Insertar el nuevo nodo en la posicion correcta
            anterior.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(actual);
        }
        
        tamaño++;
        System.out.println("Cliente insertado correctamente.");
    }
    
    //Recorre la lista e imprime todos los clientes desde el primero hasta el ultimo
    public void listarClientes() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia.");
            return;
        }
        
        System.out.println("\nListado de Clientes:");
        System.out.println("----------");
        
        Nodo1 actual = primero;
        int contador = 1;
        
        while (actual != null) {
            System.out.println(contador + ". Cedula: " + actual.getCliente().getCedula() + 
                              ", Nombre: " + actual.getCliente().getNombre());
            actual = actual.getSiguiente();
            contador++;
        }
        
        System.out.println("----------");
        System.out.println("Total de clientes: " + tamaño);
    }
}