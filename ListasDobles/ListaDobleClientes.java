class ListaDobleClientes {
    private Nodo primero;  // Puntero al primer nodo de la lista
    private Nodo ultimo;    // Puntero al ultimo nodo de la lista
    private int tamaño;        // Contador de elementos en la lista

    //Constructor de la lista doble
    public ListaDobleClientes() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }
    //Verifica si la lista esta vacia
    //@return true si la lista está vacia, false en caso contrario
    public boolean estaVacia() {
        return primero == null;
    }
    //Obtiene el tamaño actual de la lista
    //@return Numero de elementos en la lista
    public int getTamaño() {
        return tamaño;
    }
    //Inserta un nuevo cliente en la lista de forma ordenada por cedula
    public void insertarOrdenado(Cliente cliente) {
        Nodo nuevoNodo = new Nodo(cliente);
        
        // Si la lista esta vacia
        if (estaVacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } 
        // Si el nuevo nodo debe ir al principio
        else if (cliente.getCedula().compareTo(primero.getCliente().getCedula()) < 0) {
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            primero = nuevoNodo;
        } 
        // Si el nuevo nodo debe ir al final
        else if (cliente.getCedula().compareTo(ultimo.getCliente().getCedula()) > 0) {
            nuevoNodo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        } 
        // Si el nuevo nodo debe ir en algun lugar intermedio
        else {
            Nodo actual = primero;
            
            // Buscar la posicion correcta para insertar
            while (actual != null && cliente.getCedula().compareTo(actual.getCliente().getCedula()) > 0) {
                actual = actual.getSiguiente();
            }
            
            // Verificar si el cliente ya existe
            if (actual != null && cliente.getCedula().equals(actual.getCliente().getCedula())) {
                System.out.println("Error: El cliente con cedula " + cliente.getCedula() + " ya existe.");
                return;
            }
            
            // Insertar el nuevo nodo en la posicion correcta
            nuevoNodo.setSiguiente(actual);
            nuevoNodo.setAnterior(actual.getAnterior());
            actual.getAnterior().setSiguiente(nuevoNodo);
            actual.setAnterior(nuevoNodo);
        }
        
        tamaño++;
        System.out.println("Cliente insertado correctamente.");
    }
    //Recorre la lista e imprime todos los clientes desde el primero hasta el ultimo
    public void listarClientesDerecha() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia.");
            return;
        }
        
        System.out.println("\nListado de Clientes (de izquierda a derecha):");
        System.out.println("--------------------------------------------");
        
        Nodo actual = primero;
        int contador = 1;
        
        while (actual != null) {
            System.out.println(contador + ". Cedula: " + actual.getCliente().getCedula() + 
                              ", Nombre: " + actual.getCliente().getNombre());
            actual = actual.getSiguiente();
            contador++;
        }
        
        System.out.println("--------------------------------------------");
        System.out.println("Total de clientes: " + tamaño);
    }
    //Recorre la lista e imprime todos los clientes desde el ultimo hasta el primero
    public void listarClientesIzquierda() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia.");
            return;
        }
        
        System.out.println("\nListado de Clientes (de derecha a izquierda):");
        System.out.println("--------------------------------------------");
        
        Nodo actual = ultimo;
        int contador = 1;
        
        while (actual != null) {
            System.out.println(contador + ". Cedula: " + actual.getCliente().getCedula() + 
                              ", Nombre: " + actual.getCliente().getNombre());
            actual = actual.getAnterior();
            contador++;
        }
        
        System.out.println("--------------------------------------------");
        System.out.println("Total de clientes: " + tamaño);
    }
}