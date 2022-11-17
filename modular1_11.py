'''
Created on 14 nov 2022

@author: raulh
'''

lista1=[1,2,3,"Melendi",4,5,420,69,"Calico","Electronico",14,3]
lista2=[3,"Melendi",12,13,14,512,"Electronico",3]

def intersect(lista1,lista2):
    comunes=[]
    for i in lista1:
        for j in lista2:
            if j==i:
                comunes.append(i)
    sinRepetidos=[]
    for i in comunes:
        if i not in sinRepetidos:
            sinRepetidos.append(i)
    return sinRepetidos

print(intersect(lista1, lista2))