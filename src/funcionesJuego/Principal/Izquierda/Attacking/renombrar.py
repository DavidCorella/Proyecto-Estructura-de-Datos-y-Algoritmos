import os

i = 0
for i in range(10):
    archivo = "C:\\Users\David\\OneDrive\\Documents\\NetBeansProjects\\appProyecto\\src\\funcionesJuego\\Enemy\\Derecha\\Idle\\Minotaur_03_Idle_00" + str(i) + ".png"
    nombre = "C:\\Users\David\\OneDrive\\Documents\\NetBeansProjects\\appProyecto\\src\\funcionesJuego\\Enemy\\Derecha\\Idle\\Minotaur_03_Idle_" + str(i) + ".png"
    os.rename(archivo,nombre)