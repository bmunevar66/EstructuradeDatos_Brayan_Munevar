import tkinter as tk
from tkinter import messagebox

# Nodo del árbol
class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.izquierda = None
        self.derecha = None

# Árbol Binario de Búsqueda
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

# Instancia del árbol
arbol = ArbolBinario()

# Funciones de la interfaz
def insertar_dato():
    try:
        valor = int(entry_valor.get())
        arbol.insertar(valor)
        entry_valor.delete(0, tk.END)
        mostrar_mensaje(f"Insertado: {valor}")
    except ValueError:
        messagebox.showerror("Error", "Ingrese un número entero válido.")

def imprimir_in_orden():
    resultado = arbol.in_orden()
    mostrar_resultado("Recorrido In Orden", resultado)

def imprimir_pre_orden():
    resultado = arbol.pre_orden()
    mostrar_resultado("Recorrido Pre Orden", resultado)

def imprimir_post_orden():
    resultado = arbol.post_orden()
    mostrar_resultado("Recorrido Post Orden", resultado)

def mostrar_resultado(titulo, datos):
    output_text.delete("1.0", tk.END)
    output_text.insert(tk.END, f"{titulo}:\n{', '.join(map(str, datos))}")

def mostrar_mensaje(mensaje):
    output_text.delete("1.0", tk.END)
    output_text.insert(tk.END, mensaje)

# Interfaz gráfica
ventana = tk.Tk()
ventana.title("Arbol Binario Ordenado")
ventana.geometry("450x400")
ventana.config(bg="#0774f0")

label_titulo = tk.Label(ventana, text="Arbol Binario Ordenado",fg="white", font=("Arial", 16, "bold"), bg="#0774f0")
label_titulo.pack(pady=10)

entry_valor = tk.Entry(ventana, font=("Arial", 12))
entry_valor.pack(pady=5)

btn_insertar = tk.Button(ventana, text="Insertar dato", activebackground="#21ff03", activeforeground="white", command=insertar_dato, bg="#b3d9ff", font=("Arial", 12))
btn_insertar.pack(pady=5)

btn_in_orden = tk.Button(ventana, text="Imprimir en In Orden", activebackground="#21ff03", activeforeground="white", command=imprimir_in_orden, bg="#c2f0c2", font=("Arial", 12))
btn_in_orden.pack(pady=5)

btn_pre_orden = tk.Button(ventana, text="Imprimir en Pre Orden", activebackground="#21ff03", activeforeground="white", command=imprimir_pre_orden, bg="#ffd699", font=("Arial", 12))
btn_pre_orden.pack(pady=5)

btn_post_orden = tk.Button(ventana, text="Imprimir en Post Orden", activebackground="#21ff03", activeforeground="white", command=imprimir_post_orden, bg="#ffcccc", font=("Arial", 12))
btn_post_orden.pack(pady=5)

btn_salir = tk.Button(ventana, text="Salir", activebackground="#ff2903", activeforeground="white", command=ventana.quit, bg="#ff9999", font=("Arial", 12))
btn_salir.pack(pady=5)

# Área de salida para mostrar resultados
output_text = tk.Text(ventana, height=6, font=("Arial", 12), bg="white", borderwidth=2, relief="groove")
output_text.pack(pady=10, padx=10, fill=tk.BOTH, expand=False)

ventana.mainloop()