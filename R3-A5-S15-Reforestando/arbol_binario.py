import tkinter as tk
from tkinter import messagebox

# Clase Nodo para el árbol binario
class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.izquierda = None
        self.derecha = None

# Clase Árbol Binario de Búsqueda (ABB)
class ArbolBinario:
    def __init__(self):
        self.raiz = None

    def insertar(self, valor):
        if self.raiz is None:
            self.raiz = Nodo(valor)
        else:
            self._insertar_recursivo(self.raiz, valor)

    def _insertar_recursivo(self, nodo, valor):
        if valor < nodo.valor:
            if nodo.izquierda is None:
                nodo.izquierda = Nodo(valor)
            else:
                self._insertar_recursivo(nodo.izquierda, valor)
        elif valor > nodo.valor:
            if nodo.derecha is None:
                nodo.derecha = Nodo(valor)
            else:
                self._insertar_recursivo(nodo.derecha, valor)

    def in_orden(self):
        return self._in_orden_recursivo(self.raiz)

    def _in_orden_recursivo(self, nodo):
        if nodo is None:
            return []
        return self._in_orden_recursivo(nodo.izquierda) + [nodo.valor] + self._in_orden_recursivo(nodo.derecha)

    def pre_orden(self):
        return self._pre_orden_recursivo(self.raiz)

    def _pre_orden_recursivo(self, nodo):
        if nodo is None:
            return []
        return [nodo.valor] + self._pre_orden_recursivo(nodo.izquierda) + self._pre_orden_recursivo(nodo.derecha)

    def post_orden(self):
        return self._post_orden_recursivo(self.raiz)

    def _post_orden_recursivo(self, nodo):
        if nodo is None:
            return []
        return self._post_orden_recursivo(nodo.izquierda) + self._post_orden_recursivo(nodo.derecha) + [nodo.valor]

# Funciones para la interfaz gráfica
arbol = ArbolBinario()

def insertar_dato():
    try:
        valor = int(entry_valor.get())
        arbol.insertar(valor)
        entry_valor.delete(0, tk.END)
        messagebox.showinfo("Insertar", f"Se insertó el valor {valor} en el árbol.")
    except ValueError:
        messagebox.showerror("Error", "Por favor ingrese un número entero válido.")

def imprimir_in_orden():
    resultado = arbol.in_orden()
    messagebox.showinfo("In Orden", f"Recorrido In Orden:\n{resultado}")

def imprimir_pre_orden():
    resultado = arbol.pre_orden()
    messagebox.showinfo("Pre Orden", f"Recorrido Pre Orden:\n{resultado}")

def imprimir_post_orden():
    resultado = arbol.post_orden()
    messagebox.showinfo("Post Orden", f"Recorrido Post Orden:\n{resultado}")

# Interfaz gráfica
ventana = tk.Tk()
ventana.title("Árbol Binario Ordenado")
ventana.geometry("400x300")
ventana.config(bg="#e6f2ff")

label_titulo = tk.Label(ventana, text="Árbol Binario Ordenado", font=("Arial", 16, "bold"), bg="#e6f2ff")
label_titulo.pack(pady=10)

entry_valor = tk.Entry(ventana, font=("Arial", 12))
entry_valor.pack(pady=5)

btn_insertar = tk.Button(ventana, text="Insertar dato", command=insertar_dato, bg="#b3d9ff", font=("Arial", 12))
btn_insertar.pack(pady=5)

btn_in_orden = tk.Button(ventana, text="Imprimir en In Orden", command=imprimir_in_orden, bg="#c2f0c2", font=("Arial", 12))
btn_in_orden.pack(pady=5)

btn_pre_orden = tk.Button(ventana, text="Imprimir en Pre Orden", command=imprimir_pre_orden, bg="#ffd699", font=("Arial", 12))
btn_pre_orden.pack(pady=5)

btn_post_orden = tk.Button(ventana, text="Imprimir en Post Orden", command=imprimir_post_orden, bg="#ffcccc", font=("Arial", 12))
btn_post_orden.pack(pady=5)

btn_salir = tk.Button(ventana, text="Salir", command=ventana.quit, bg="#ff9999", font=("Arial", 12))
btn_salir.pack(pady=5)

ventana.mainloop()
