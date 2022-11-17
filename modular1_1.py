'''
Created on 9 nov 2022

@author: raulh
'''
from random import randint
import time

def aleatorizarNumero():
    numero = randint(0, 1000)
    return numero

def mayor():
    mayor=0
    for i in range(len(n)):
        if n[i]>mayor:
            mayor=n[i]
    print(f"El numero mayor es el {mayor}")
    time.sleep(2)

def menor():
    menor=1001
    for i in range(len(n)):
        if n[i]<menor:
            menor=n[i]
    print(f"El numero menor es el {menor}")
    time.sleep(2)

def sumar():
    total=0
    for i in range(len(n)):
        total+=n[i]
    #
    #Esto es para añadir el "." que se añade cada tres numeros
    #Como la gran amyoria de resultados van a ser de 4 o 5 cifras, está adaptado a ello
    #No se me ha ocurrido una manera para hacerlo más global y flexible
    parte1=str(total)[-6:-3]
    parte2=str(total)[-3:]
    print(f"La suma de todo es {parte1}.{parte2}")
    time.sleep(2)
    
def media():
    total=0
    for i in range(len(n)):
        total+=n[i]
    print(f"La media total es {total/cantidad}")
    time.sleep(2)
    
def sustituir(elejido):
    terminado=True
    while terminado:
        seguro=input(f"El número de la posición {elejido} es {n[elejido]}, ¿está seguro de la elección (S/N)?: ").lower()
        if seguro=="s":
            n[elejido]=int(input("Introduzca el número deseado: "))
            while cantidad<n[elejido]<0:
                n[elejido]=int(input("El número debe ser menor a",cantidad,"y mayor a 0: "))    
            return elejido
            terminado=False
        else:
            elejido=int(input("Decida otra posicion: "))
            while 99<elejido or elejido<0:
                elejido=int(input("Decida una posicion válida (99-0): "))
def mostrar():
    print("Imprimiendo con forma de cuadrado 10x10")
    time.sleep(4)
    for i in range(int(len(n)/10)):
        mensaje=""
        for j in range(int(len(n)/10)):
            contado=i*10+j
            if contado<=99 and contado!=99:
                mensaje+=" "+str(n[contado])+","
            else:
                mensaje+=" "+str(n[contado])
        print(mensaje)
    time.sleep(6)
menu= '''
a) Conocer el mayor
b) Conocer el menor
c) Obtener la suma de todos los números
d) Obtener la media
e) Sustituir el valor de un elemento por otro numero introducido por teclado
f) Mostrar todos los números
g) Salir del programa
'''



n = []
eleccion=""
cantidad=100

for i in range(cantidad):
    n.append(aleatorizarNumero())

while eleccion!="g":
    print(menu)
    eleccion=input("Eliga opción: ")
    if eleccion=="a":
        mayor()
    elif eleccion=="b":
        menor()
    elif eleccion=="c":
        sumar()
    elif eleccion=="d":
        media()
    elif eleccion=="e":
        seleccion=int(input("Introduzca la posición que quiere cambiar: "))
        while 99<seleccion or seleccion<0:
            seleccion=int(input("Introduzca un número valido (0-99): "))
        sustituir(seleccion)
        print(f"Cambiado con éxito a {n[seleccion]}")
        time.sleep(2)
    elif eleccion=="f":
        mostrar()
    elif eleccion=="g":
        print("Muchas gracias por usar nuestro programa")
        print("Cerrando programa...")