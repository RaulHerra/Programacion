'''
Created on 11 nov 2022

@author: raulh
'''
import time

def conocerPrimos(lista):
    divisores=0
    n=0
    contador=0
    primos=[]
    while contador!=len(lista):
        divisores=0
        for i in range(1,lista[n]):
            if lista[n]%i==0:
                divisores = divisores +1
        
        if divisores==1:
                primos.append(lista[n])
        n+=1
        contador+=1
    return primos

def sumarLista(lista):
    total=0
    for i in range(len(lista)):
        total+=lista[i]
    return total

def promedioLista(lista):
    total=0
    for i in range(len(lista)):
        total+=lista[i]
    media=total/len(lista)
    return media
    
def devolverFacts(lista):
    for i in range(len(lista)):
        fact=1
        aux = lista[i]
        while(aux>1):
            fact *= aux
            aux -= 1
        print(f"{lista[i]}! = {fact}")
        time.sleep(2)
num=0
numeros=[]

print("Introduzca un numero negativo para finalizar la inserción de números")
num=int(input("Introduzca un número para su lista: "))
while num>=0:
    numeros.append(num)
    num=int(input("Introduzca un número para su lista: "))
menu= '''
a) Conocer los numeros primos
b) Obtener la suma de todos los números
c) Obtener el promedio
d) Lista de factoriales de cada numero de la lista
e) Cerrar programa
'''
eleccion=""
while eleccion!="e":
    print(menu)
    eleccion = input("Opcion: ")
    if eleccion=="a":
        print(f"Los primos son: {conocerPrimos(numeros)}")
        time.sleep(3)
    elif eleccion=="b":
        print(f"La suma de todos los numeros es: {sumarLista(numeros)}")
        time.sleep(3)
    elif eleccion=="c":
        print(f"El promedio de todos los numeros es: {promedioLista(numeros)}")
        time.sleep(3)
    elif eleccion=="d":
        print("Imprimiendo factoriales...")
        devolverFacts(numeros)
    elif eleccion=="e":
        print('''gracias por usar nuestro programa
        Cerrando programa...''')
    else:
        print("Opción incorrecta")
        time.sleep(1)