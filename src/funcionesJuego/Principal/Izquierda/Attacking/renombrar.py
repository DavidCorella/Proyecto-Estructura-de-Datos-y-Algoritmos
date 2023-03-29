import os

carpeta = "Attacking"
accion = "Attack"
i = 10
for i in range(0,12):
    archivo = "C:\\Users\David\\OneDrive\\Documents\\NetBeansProjects\\appProyecto\\src\\funcionesJuego\\Boss1\\Derecha\\"+carpeta+"\\Wraith_01_"+accion +"_"+ str(i) + ".png"
    nombre = "C:\\Users\David\\OneDrive\\Documents\\NetBeansProjects\\appProyecto\\src\\funcionesJuego\\Boss1\\Derecha\\"+carpeta+"\\"+accion+"_" + str(i) + ".png"
    os.rename(archivo,nombre)
