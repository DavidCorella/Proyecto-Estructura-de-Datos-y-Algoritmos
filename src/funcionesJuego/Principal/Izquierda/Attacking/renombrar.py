import os

i = 0
for i in range(10):
    archivo = str(os.getcwd()) + "\\Minotaur_03_Dying_00" + str(i) + ".png"
    nombre = str(os.getcwd() )+ "\\Minotaur_03_Dying_" + str(i) + ".png"
    print (archivo)
   # os.rename(archivo,nombre)