import tkinter as tk
from tkinter import messagebox
from collections import deque

# Creamos la bicola usando deque
bicola = deque()

# Funciones para manejar las operaciones de la bicola
def insertar_derecha():
    valor = entry_valor.get()
    if valor:
        bicola.append(valor)
        entry_valor.delete(0, tk.END)
        actualizar_lista()
    else:
        messagebox.showwarning("Atención", "Debes ingresar un valor.")

def insertar_izquierda():
    valor = entry_valor.get()
    if valor:
        bicola.appendleft(valor)
        entry_valor.delete(0, tk.END)
        actualizar_lista()
    else:
        messagebox.showwarning("Atención", "Debes ingresar un valor.")

def atender_derecha():
    if bicola:
        valor = bicola.pop()
        messagebox.showinfo("Elemento atendido", f"Se eliminó por la derecha: {valor}")
        actualizar_lista()
    else:
        messagebox.showwarning("Atención", "La bicola está vacía.")

def atender_izquierda():
    if bicola:
        valor = bicola.popleft()
        messagebox.showinfo("Elemento atendido", f"Se eliminó por la izquierda: {valor}")
        actualizar_lista()
    else:
        messagebox.showwarning("Atención", "La bicola está vacía.")

def actualizar_lista():
    lista.delete(0, tk.END)
    for i, val in enumerate(bicola):
        lista.insert(tk.END, f"{i + 1}. {val}")

def salir():
    ventana.destroy()

# Ventana principal
ventana = tk.Tk()
ventana.title("Bicola - Interfaz Gráfica")
ventana.geometry("500x400")
ventana.resizable(False, False)

# Entrada de valor
tk.Label(ventana, text="Ingrese un valor:").pack(pady=10)
entry_valor = tk.Entry(ventana, width=40)
entry_valor.pack()

# Botones
frame_botones = tk.Frame(ventana)
frame_botones.pack(pady=15)

tk.Button(frame_botones, text="Insertar por la derecha ↓", command=insertar_derecha).grid(row=0, column=0, padx=5, pady=5)
tk.Button(frame_botones, text="Insertar por la izquierda ↑", command=insertar_izquierda).grid(row=0, column=1, padx=5, pady=5)
tk.Button(frame_botones, text="Eliminar por la derecha ↓", command=atender_derecha).grid(row=1, column=0, padx=5, pady=5)
tk.Button(frame_botones, text="Eliminar por la izquierda ↑", command=atender_izquierda).grid(row=1, column=1, padx=5, pady=5)

# Lista para mostrar elementos
tk.Label(ventana, text="Contenido de la Bicola:").pack(pady=10)
lista = tk.Listbox(ventana, width=50, height=10)
lista.pack()

# Botón salir
tk.Button(ventana, text="Salir", command=salir, bg="red", fg="white").pack(pady=10)

# Ejecutar la ventana
ventana.mainloop()
