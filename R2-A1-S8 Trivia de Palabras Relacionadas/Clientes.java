class Clientes {
    private String cedula;
    private String nombre;
public Clientes(String cedula,String nombre){
    this.cedula=cedula;
    this.nombre=nombre;
}
public String getCedula(){
    return cedula;
}
public String getNombre(){
    return nombre;
}
public void setCedula(String cedula){
    this.cedula=cedula;
}
public void setNombre(String nombre){
    this.nombre=nombre;
}
@ Override
public String toString(){
    return "Cliente{cedula="+cedula+", nombre="+nombre+'}';
}
}