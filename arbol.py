import tkinter as tk

# Nodo del árbol
class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.izquierda = None
        self.derecha = None

# Árbol Binario
class ArbolBinario:
    def __init__(self):
        self.raiz = None

    def insertar(self, valor):
        if self.raiz is None:
            self.raiz = Nodo(valor)
        else:
            self._insertar(self.raiz, valor)

    def _insertar(self, nodo, valor):
        if valor < nodo.valor:
            if nodo.izquierda is None:
                nodo.izquierda = Nodo(valor)
            else:
                self._insertar(nodo.izquierda, valor)
        elif valor > nodo.valor:
            if nodo.derecha is None:
                nodo.derecha = Nodo(valor)
            else:
                self._insertar(nodo.derecha, valor)

    def inorden(self, nodo, resultado):
        if nodo:
            self.inorden(nodo.izquierda, resultado)
            resultado.append(str(nodo.valor))
            self.inorden(nodo.derecha, resultado)

    def preorden(self, nodo, resultado):
        if nodo:
            resultado.append(str(nodo.valor))
            self.preorden(nodo.izquierda, resultado)
            self.preorden(nodo.derecha, resultado)

    def postorden(self, nodo, resultado):
        if nodo:
            self.postorden(nodo.izquierda, resultado)
            self.postorden(nodo.derecha, resultado)
            resultado.append(str(nodo.valor))

# Dibujo del árbol
def dibujar_arbol(canvas, nodo, x, y, dx):
    if nodo:
        r = 15
        canvas.create_oval(x - r, y - r, x + r, y + r, fill="cyan")
        canvas.create_text(x, y, text=str(nodo.valor), font=("Arial", 12, "bold"))
        if nodo.izquierda:
            canvas.create_line(x, y + r, x - dx, y + 60 - r)
            dibujar_arbol(canvas, nodo.izquierda, x - dx, y + 60, dx // 2)
        if nodo.derecha:
            canvas.create_line(x, y + r, x + dx, y + 60 - r)
            dibujar_arbol(canvas, nodo.derecha, x + dx, y + 60, dx // 2)

# Lógica principal
arbol = ArbolBinario()

def insertar_y_dibujar():
    try:
        valor = int(entry_valor.get())
        arbol.insertar(valor)
        entry_valor.delete(0, tk.END)
        canvas.delete("all")
        dibujar_arbol(canvas, arbol.raiz, 400, 40, 120)
        resultado_text.set("")
    except ValueError:
        resultado_text.set("Ingresa un número válido.")

def mostrar_inorden():
    resultado = []
    arbol.inorden(arbol.raiz, resultado)
    resultado_text.set("In orden: " + ", ".join(resultado))

def mostrar_preorden():
    resultado = []
    arbol.preorden(arbol.raiz, resultado)
    resultado_text.set("Pre orden: " + ", ".join(resultado))

def mostrar_postorden():
    resultado = []
    arbol.postorden(arbol.raiz, resultado)
    resultado_text.set("Post orden: " + ", ".join(resultado))

# Interfaz
ventana = tk.Tk()
ventana.title("Árbol Binario")
ventana.geometry("820x900")
ventana.config(bg="#0774f0")

label_titulo = tk.Label(ventana, text="Arbol Binario Ordenado",fg="white", font=("Arial", 16, "bold"), bg="#0774f0")
label_titulo.pack(pady=10)

entry_valor = tk.Entry(ventana, font=("Arial", 14))
entry_valor.pack(pady=10)

btn_insertar = tk.Button(ventana, text="Insertar", activebackground="#21ff03", activeforeground="white", font=("Arial", 12), bg="#b3d9ff", command=insertar_y_dibujar)
btn_insertar.pack(pady=2)

btn_in_orden = tk.Button(ventana, text="In Orden", activebackground="#21ff03", activeforeground="white", command=mostrar_inorden, bg="#b4ffb4", font=("Arial", 12))
btn_in_orden.pack(pady=2)

btn_pre_orden = tk.Button(ventana, text="Pre Orden", activebackground="#21ff03", activeforeground="white", command=mostrar_postorden, bg="#fff890", font=("Arial", 12))
btn_pre_orden.pack(pady=2)

btn_post_orden = tk.Button(ventana, text="Post Orden", activebackground="#21ff03", activeforeground="white", command=mostrar_preorden, bg="#dba5f0", font=("Arial", 12))
btn_post_orden.pack(pady=2)

btn_salir = tk.Button(ventana, text="Salir", activebackground="#ff2903", activeforeground="white", command=ventana.quit, bg="#ff8686", font=("Arial", 12))
btn_salir.pack(pady=2)

resultado_text = tk.StringVar()
tk.Label(ventana, textvariable=resultado_text, font=("Arial", 16, "bold"),fg="white", bg="#0774f0").pack()

canvas = tk.Canvas(ventana, width=780, height=880, bg="white")
canvas.pack(pady=5)

ventana.mainloop()
