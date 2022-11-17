'''
Created on 11 nov 2022

@author: raulh
'''

def mostrarMayor(lista):
    mayor=0
    for i in range(len(lista)):
        if lista[i]>mayor:
            mayor=lista[i]
    return mayor

def mostrarPares(lista):
    pares=[]
    for i in range(len(lista)):
        if lista[i]%2==0:
            pares.append(lista[i])
    return pares

num=0
numeros=[]

print("Introduzca un numero negativo para finalizar la inserción de números")
num=int(input("Introduzca un número para su lista: "))
while num>=0:
    numeros.append(num)
    num=int(input("Introduzca un número para su lista: "))
    
print(f"El número mayor es: {mostrarMayor(numeros)}")
print(f"Los números pares son: {mostrarPares(numeros)}")