'''
Created on 2 dic 2022

@author: raulh
'''
from src.Python.modular3.modular3_8 import isVocal

def vocalesAlfinal(frase):
    contador=0
    for i in range(len(frase)):
        if isVocal(frase[i-contador]):
            frase=frase[0:i-contador]+frase[i-contador+1:]+frase[i-contador]
            contador+=1
        elif frase[i-contador]==" ":
            frase=frase[0:i-contador]+frase[i-contador+1:]
            contador+=1
    return frase
    
frase="curso de programacion"
print(vocalesAlfinal(frase))