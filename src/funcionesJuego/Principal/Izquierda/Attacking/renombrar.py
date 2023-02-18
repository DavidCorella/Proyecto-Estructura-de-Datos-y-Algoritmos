import os

i = 0
for i in range(10):
    archivo = "C:\\Users\David\\OneDrive\\Documents\\NetBeansProjects\\appProyecto\\src\\funcionesJuego\\Principal\\Derecha\\Attacking\\Satyr_01_Attacking_00" + str(i) + ".png"
    nombre = "C:\\Users\David\\OneDrive\\Documents\\NetBeansProjects\\appProyecto\\src\\funcionesJuego\\Principal\\Derecha\\Attacking\\Satyr_01_Attacking_" + str(i) + ".png"
    os.rename(archivo,nombre)