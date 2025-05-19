import tkinter as tk
from tkinter import messagebox

# Lista donde se almacenarán los pasos de la mudanza
pasos = []

# Función recursiva que resuelve el problema de la mudanza con cajas
def mudanza_cajas(n, origen, destino, auxiliar):
    if n == 1:
        pasos.append(f"Mover Caja 1 de la {origen} a la {destino}")
    else:
        mudanza_cajas(n - 1, origen, auxiliar, destino)
        pasos.append(f"Mover Caja {n} de la {origen} a la {destino}")
        mudanza_cajas(n - 1, auxiliar, destino, origen)

# Ejecuta el algoritmo al presionar el botón
def resolver():
    pasos.clear()
    try:
        n = int(entry_discos.get())
        if n <= 0:
            raise ValueError
    except ValueError:
        messagebox.showerror("Error", "Por favor, ingresa un número entero positivo.")
        return

    # Inicia el algoritmo con nombres personalizados
    mudanza_cajas(n, "Mesa A", "Mesa C", "Mesa B")
    mostrar_pasos()

# Muestra los pasos en el cuadro de texto
def mostrar_pasos():
    texto_resultado.delete("1.0", tk.END)
    for paso in pasos:
        texto_resultado.insert(tk.END, paso + "\n")

# ---------------------------
# INTERFAZ GRÁFICA CON TKINTER
# ---------------------------

ventana = tk.Tk()
ventana.title("Simulación de Mudanza - Cajas en Mesas")
ventana.geometry("600x500")
ventana.resizable(False, False)

tk.Label(ventana, text="Simulación de Mudanza con Cajas", font=("Arial", 16, "bold")).pack(pady=10)
tk.Label(ventana, text="Ingrese cuántas cajas desea mover:").pack()

entry_discos = tk.Entry(ventana, width=10)
entry_discos.pack(pady=5)

tk.Button(ventana, text="Iniciar mudanza", command=resolver).pack(pady=10)

texto_resultado = tk.Text(ventana, width=70, height=20)
texto_resultado.pack(pady=10)

tk.Button(ventana, text="Salir", command=ventana.destroy, bg="red", fg="white").pack(pady=10)

ventana.mainloop()
