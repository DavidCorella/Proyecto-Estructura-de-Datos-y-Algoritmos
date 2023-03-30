import os

carpeta = "Walking"
accion = "Walking"
Direccion1 = "Izquierda"
Direccion = "Derecha"
for i in range(6,24):
    archivo = "C:\\Users\David\\OneDrive\\Escritorio\\"+Direccion1+"\\"+carpeta+"\\Fallen_Angels_"+accion +"_"+ str(i) + ".png"
    nombre = "C:\\Users\David\\OneDrive\\Escritorio\\"+Direccion1+"\\"+carpeta+"\\"+accion+"_" + str(i) + ".png"
    os.rename(archivo,nombre)

