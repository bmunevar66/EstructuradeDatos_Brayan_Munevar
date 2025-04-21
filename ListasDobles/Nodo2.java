class Nodo2 {
    private Cliente cliente;      // Dato almacenado en el nodo
    private Nodo2 siguiente;  // Referencia al siguiente nodo
    private Nodo2 anterior;   // Referencia al nodo anterior

    public Nodo2(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
        this.anterior = null;
    }
    //Obtiene el cliente almacenado en el nodo
    //@return Cliente del nodo
    public Cliente getCliente() {
        return cliente;
    }
    //Establece el cliente del nodo
    //@param cliente Nuevo cliente a almacenar
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    //Obtiene el siguiente nodo de la lista
    //@return Referencia al siguiente nodo
    public Nodo2 getSiguiente() {
        return siguiente;
    }
    //Establece el siguiente nodo en la lista
    //@param siguiente Nuevo nodo siguiente
    public void setSiguiente(Nodo2 siguiente) {
        this.siguiente = siguiente;
    }
    //Obtiene el nodo anterior de la lista
    //@return Referencia al nodo anterior
    public Nodo2 getAnterior() {
        return anterior;
    }
    //Establece el nodo anterior en la lista
    //@param anterior Nuevo nodo anterior
    public void setAnterior(Nodo2 anterior) {
        this.anterior = anterior;
    }
}
