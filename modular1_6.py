'''
Created on 12 nov 2022

@author: raulh
'''

def estaOrdenada(lista):
    ordenada = True

    for i in range(1,len(lista)):
        if lista[i-1]<lista[i]:
            ordenada=False
    return ordenada

lista=[15, 64, 8, 6, 54, 11, 576, 54, 11, 5, 6]

        
print(f"La lista {lista} está ordenada: {estaOrdenada(lista)}")