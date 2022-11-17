'''
Created on 9 nov 2022

@author: raulh
'''

def moverIzquierda(lista):
    dato=lista[0]
    lista.pop(0)
    lista.append(dato)
    return lista
def moverDerecha(lista):
    a_borrar=0
    a_escribir=lista[0] 
    for i in range(len(lista)):
        a_borrar = lista[(i+1)%len(lista)]
        lista[(i+1)%len(lista)]=a_escribir
        a_escribir = a_borrar
    return lista

n = []
numeros=0
eleccion=""

while numeros!=10:
    n.append(int(input(f"Introduzca el {numeros+1}º numero: ")))
    numeros+=1
print("Esta es su lista:",n)

while eleccion!="s":
    print("(Escriba la palabra ''salir'' para cerrar el programa)")
    eleccion=(input("¿Desea mover la lista una posición a la izquierda (I) o a la derecha (D)?").lower())[0]
    while eleccion!="s" and eleccion!="i" and eleccion!="d":
        eleccion=(input("Introduzca un valor valido (I/D/salir)").lower())[0]
    print("")
    if eleccion=="s":
        pass
    elif eleccion=="i":
        pasos=int(input("¿Cuantas posiciones desea mover la lista hacia la izquierda?: "))
        while pasos<0:
            pasos=int(input("Introduzca un valor positivo: "))
        while pasos!=0:
            moverIzquierda(n)
            pasos-=1
        print("Su lista queda así: ",n)
    else:
        pasos=int(input("¿Cuantas posiciones desea mover la lista hacia la derecha?: "))
        while pasos<0:
            pasos=int(input("Introduzca un valor positivo: "))
        while pasos!=0:
            moverDerecha(n)
            pasos-=1
        print("Su lista queda así: ",n)
    print("")
print("Gracias por usar nuestro programa, su resultado final es: ",n)