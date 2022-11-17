'''
Created on 14 nov 2022

@author: raulh
'''
from random import randint
import time

def menores(k, lista):
    menores = []
    for i in range(len(lista)):
        if lista[i]<k:
            menores.append(lista[i])
    return menores

def mayores(k, lista):
    mayores = []
    for i in range(len(lista)):
        if lista[i]>k:
            mayores.append(lista[i])
    return mayores

def multiplos(k, lista):
    multiplos = []
    for i in range(len(lista)):
        if lista[i]%k==0:
            multiplos.append(lista[i])
    return multiplos

k = randint(1, 50)
lista = []

for i in range(49):
    lista.append(randint(0, 100))

menu='''
a) Devolver números menores que K
b) Devolver números mayores que K
c) Multiplos de K
d) Cerrar programa'''
eleccion=""

while eleccion!="d":
    print(menu)
    eleccion=input("Opción: ")
    
    if eleccion=="a":
        print(menores(k, lista))
        time.sleep(2)
    elif eleccion=="b":
        print(mayores(k, lista))
        time.sleep(2)
    elif eleccion=="c":
        print(multiplos(k, lista))
        time.sleep(2)
    elif eleccion=="d":
        print('''Gracias por usar nuestro programa
        Cerrando programa...''')
    else:
        print("Esa opción no existe")
        time.sleep(2)