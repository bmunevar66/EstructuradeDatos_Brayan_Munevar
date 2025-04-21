// Clase que representa un nodo de la lista
class Nodo1 {
    private Clientes cliente;  // Dato almacenado en el nodo
    private Nodo1 siguiente;   // Referencia al siguiente nodo
    
    //Constructor de la clase Nodo
    public Nodo1(Clientes cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }
    //Obtiene el cliente almacenado en el nodo
    public Clientes getCliente() {
        return cliente;
    }
    //Obtiene el siguiente nodo de la lista
    public Nodo1 getSiguiente() {
        return siguiente;
    }
    //Establece el cliente del nodo
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    //Establece el siguiente nodo en la lista
    public void setSiguiente(Nodo1 siguiente) {
        this.siguiente = siguiente;
    }
}