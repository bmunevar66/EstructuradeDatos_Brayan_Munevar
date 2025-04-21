class Cliente {
    private String cedula;
    private String nombre;
     // @param cedula identificacion
     // @param nombre Nombre completo 
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }
    //Obtiene la cédula del cliente
    //@return Cédula
    public String getCedula() {
        return cedula;
    }
    //Establece la cédula del cliente
    //@param cedula Nueva 
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    //Obtiene el nombre del cliente
    //@return Nombre 
    public String getNombre() {
        return nombre;
    }
    //Establece el nombre del cliente
    // @param nombre Nuevo nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Representación en texto del cliente
    //@return Información del cliente en formato de texto
    @Override
    public String toString() {
        return "Cliente{cedula=" + cedula + ", nombre=" + nombre + '}';
    }
}