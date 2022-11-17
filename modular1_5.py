'''
Created on 11 nov 2022

@author: raulh
'''

def reverse(lista):
    listaAuxiliar=[]
    for i in range(len(lista)):
        listaAuxiliar.append(lista[(i+1)*-1])
    return listaAuxiliar

frase=["Di","buen","dia","a","papa"]
print(reverse(frase))