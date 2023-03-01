import os

accion = "Hurt"
i = 10
for i in range(0,10):
    print(i)
    archivo = "C:\\Users\David\\OneDrive\\Documents\\NetBeansProjects\\appProyecto\\src\\funcionesJuego\\Enemy\\Derecha\\"+accion+"\\Minotaur_03_"+accion+"_00" + str(i) + ".png"
    nombre = "C:\\Users\David\\OneDrive\\Documents\\NetBeansProjects\\appProyecto\\src\\funcionesJuego\\Enemy\\Derecha\\"+accion+"\\Minotaur_03_"+accion+"_" + str(i) + ".png"
    os.rename(archivo,nombre)