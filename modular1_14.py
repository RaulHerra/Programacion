'''
Created on 14 nov 2022

@author: raulh
'''

def palabraMasLarga(lista):
    palabra=""
    contadorAnterior=0
    for i in lista:
        if len(i)>=len(palabra):
            contador=0
            for j in i:
                for k in i:
                    if k==j:
                        contador+=1
                    if contadorAnterior<contador:
                        contadorAnterior=contador
                        palabra=i
    return palabra
    
    
    
lista=["Pedro","Abad","Raul","Laura","Ramon","Josué"]

print(palabraMasLarga(lista))
