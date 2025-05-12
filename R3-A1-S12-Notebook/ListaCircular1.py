import tkinter as tk
from tkinter import messagebox, simpledialog

class Nodo1:
    def __init__(self, cedula, nombre):
        self.cedula = cedula
        self.nombre = nombre
        self.siguiente = None


class ListaCircular1:
    def __init__(self):
        self.Inicio = None

    def esta_vacia(self):
        return self.Inicio is None

    def insertar_cliente(self, cedula, nombre):
        nueva = Nodo1(cedula, nombre)
        if self.esta_vacia():
            nueva.siguiente = nueva
            self.Inicio = nueva
        else:
            nueva.siguiente = self.Inicio.siguiente
            self.Inicio.siguiente = nueva
            self.Inicio = nueva

    def obtener_lista_clientes(self):
        clientes = []
        if self.esta_vacia():
            return clientes

        actual = self.Inicio.siguiente
        while True:
            clientes.append((actual.cedula, actual.nombre))
            actual = actual.siguiente
            if actual == self.Inicio.siguiente:
                break
        return clientes


class Aplicacion:
    def __init__(self, root):
        self.root = root
        self.root.title("Gestión de Clientes")
        self.lista = ListaCircular1()

        self.titulo = tk.Label(root, text="Sistema de Gestión de Clientes", font=("Arial", 16))
        self.titulo.pack(pady=10)

        self.btn_insertar = tk.Button(root, text="Insertar Cliente", command=self.insertar_cliente)
        self.btn_insertar.pack(pady=5)

        self.btn_listar = tk.Button(root, text="Listar Clientes", command=self.listar_clientes)
        self.btn_listar.pack(pady=5)

        self.btn_salir = tk.Button(root, text="Salir", command=root.quit)
        self.btn_salir.pack(pady=5)

    def insertar_cliente(self):
        cedula = simpledialog.askstring("Cédula", "Ingrese la cédula del cliente:")
        if cedula is None or cedula.strip() == "":
            return
        nombre = simpledialog.askstring("Nombre", "Ingrese el nombre del cliente:")
        if nombre is None or nombre.strip() == "":
            return

        self.lista.insertar_cliente(cedula, nombre)
        messagebox.showinfo("Éxito", f"Cliente {nombre} con cédula {cedula} insertado.")

    def listar_clientes(self):
        clientes = self.lista.obtener_lista_clientes()
        if not clientes:
            messagebox.showinfo("Lista Vacía", "No hay clientes registrados.")
            return

        lista_texto = "\n".join([f"{cedula} - {nombre}" for cedula, nombre in clientes])
        messagebox.showinfo("Listado de Clientes", lista_texto)


if __name__ == "__main__":
    root = tk.Tk()
    app = Aplicacion(root)
    root.mainloop()
