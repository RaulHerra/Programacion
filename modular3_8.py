'''
Created on 2 dic 2022

@author: raulh
'''

def isVocal(letra):
    letra=letra.lower()
    if letra=="a" or letra=="e" or letra=="i" or letra=="o" or letra=="u":
        return True
    else:
        return False

def contarVocales(string):
    contador=0
    vocalesContadas=["","","","",""]
    
    for i in string.lower():
        if isVocal(i) and not(i==vocalesContadas[0] or i==vocalesContadas[1] or i==vocalesContadas[2] or i==vocalesContadas[3] or i==vocalesContadas[4]):
                vocalesContadas[contador]=i
                contador+=1
    return contador


cadena="Abaco"

print(f"Hay {contarVocales(cadena)} vocales distintas")