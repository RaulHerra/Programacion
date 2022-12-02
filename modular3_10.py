'''
Created on 2 dic 2022

@author: raulh
'''
from src.Python.modular3.modular3_2 import myLowers

def contarPalabras(cadena):
    caracterAnterior=""
    contadorPalabras=0
    cadena=cadena.lower()
    
    for i in range(len(cadena)):
        if cadena[i]==" " and caracterAnterior!=" " or (i==len(cadena)-1 and myLowers(cadena[i])) :
            contadorPalabras+=1
        caracterAnterior=cadena[i]    
    return contadorPalabras

#El programa tiene en cuenta lo que menciona el enunciado sobre los espacios
frase="He estudiado lo justo"
print(f"La frase '{frase}', tiene {contarPalabras(frase)} palabras")