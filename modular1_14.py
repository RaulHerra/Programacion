'''
Created on 14 nov 2022

@author: raulh
'''

def palabraMasLarga(lista):
    aux= [""]
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
                        aux.pop(0); aux.append(i)
    return aux
    
    
    
lista=["Pedro","Abad","Raul","Laura","Ramon","Josué"]

print(palabraMasLarga(lista))