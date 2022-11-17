'''
Created on 14 nov 2022

@author: raulh
'''

lista1=[1,2,3,"Melendi",4,5,420,69,"Calico","Electronico",14,3]
lista2=[3,"Melendi",12,13,14,512,"Electronico",3]

def unionLista(lista1,lista2):
    union=[]
    for i in lista1:
        union.append(i)    
    for j in lista2:
        union.append(j)
    sinRepetidos=[]
    for i in union:
        if i not in sinRepetidos:
            sinRepetidos.append(i)
    return sinRepetidos

print(unionLista(lista1, lista2))