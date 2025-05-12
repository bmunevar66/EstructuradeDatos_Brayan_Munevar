class Nodo:
    def __init__(self, cedula, nombre):
        self.cedula = cedula
        self.nombre = nombre
        self.siguiente = None


class ListaCircular:
    def __init__(self):
        self.Inicio = None

    def esta_vacia(self):
        return self.Inicio is None

    def insertar_cliente(self, cedula, nombre):
        nueva = Nodo(cedula, nombre)
        if self.esta_vacia():
            nueva.siguiente = nueva
            self.Inicio = nueva
        else:
            nueva.siguiente = self.Inicio.siguiente
            self.Inicio.siguiente = nueva
            self.Inicio = nueva
        print(f"Cliente {nombre} con cédula {cedula} insertado correctamente.")

    def listar_clientes_derecha(self):
        if self.esta_vacia():
            print("No hay clientes registrados.")
            return

        actual = self.Inicio.siguiente
        print("\n----- Listado de Clientes -----")
        print("Cédula\t\tNombre")
        while True:
            print(f"{actual.cedula}\t\t{actual.nombre}")
            actual = actual.siguiente
            if actual == self.Inicio.siguiente:
                break
        print("-----------------------------\n")


def menu_principal():
    lista_clientes = ListaCircular()
    while True:
        print("\n===== SISTEMA DE GESTIÓN DE CLIENTES =====")
        print("1. Insertar cliente")
        print("2. Listar clientes hacia la derecha")
        print("3. Salir")

        try:
            opcion = int(input("\nSeleccione una opción: "))
            if opcion == 1:
                cedula = input("Ingrese la cédula del cliente: ")
                nombre = input("Ingrese el nombre del cliente: ")
                lista_clientes.insertar_cliente(cedula, nombre)

            elif opcion == 2:
                lista_clientes.listar_clientes_derecha()

            elif opcion == 3:
                print("Gracias por usar el sistema. ¡Hasta pronto!")
                break
            else:
                print("Opción no válida. Intente de nuevo.")
        except ValueError:
            print("Por favor, ingrese un número válido.")


if __name__ == "__main__":
    menu_principal()

