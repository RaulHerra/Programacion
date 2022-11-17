'''
Created on 14 nov 2022

@author: raulh
'''

def mostrarNombres(letra, lista):
    aux = []
    i=0
    for i in range(len(lista)):
        if lista[i][0]==letra:
            aux.append(lista[i])
    if len(aux)==0:
        aux = f"No existe un nombre en la lista con {letra}"
    return aux

nombres=["Mohamed","Jesus","Jesus Funes","Alejandra","Dario Conde","Dario Jose","César","Raúl","Juan Antonio","Juanan","Jose Manuel","Hermes","Alfonso","Manuel","Jose Carlos","Moisés","Yeray","Francisco José","Iván","Jose Miguel","Ana",]

letra = input("Introduzca la letra que desea: ").upper()
if letra.isdigit()==True:
    while letra.isdigit()==True:
        letra = input("Por favor, introduzca una letra: ").upper()
print(mostrarNombres(letra, nombres))