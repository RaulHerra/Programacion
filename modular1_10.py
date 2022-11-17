'''
Created on 17 nov 2022

@author: raulh
'''
def conversorBinarioDecimal(numero):
    numero_decimal = 0
    posicion=len(numero)-1

    for i in numero:
        numero=int(i)
        numero_decimal+=numero*2**posicion
        posicion -= 1

    return numero_decimal

def conversorDecimalBinario(numero):
    numeroBinario = 0
    posicionBinario = 1
    numero=int(numero)
    while numero != 0:
        numeroBinario = numeroBinario+numero%2*posicionBinario
        numero//=2
        posicionBinario*=10

    return numeroBinario

numero = input("Introduce un número decimal o binario(Ejemplos: 10100101b, 123d):")

correcto = False
finalizado=False
while finalizado==False:
    if numero[len(numero)-1:len(numero)] == "b":
        while correcto == False:
            tmp = str(numero[:-1])
            for i in range(len(tmp)):
                if tmp[i] == "0" or tmp[i] == "1":
                    correcto = True
                else:
                    correcto = False
    
            if correcto == False:
                numero = input("Número incorrecto, por favor siga la secuencia (10100101b):")
        print(conversorBinarioDecimal(tmp))
        finalizado=True
        
    elif numero[len(numero)-1:len(numero)] == "d":
        numero = int(numero[:-1])
        while numero < 0 :
            numero = input("Introduzca un número positivo (1234d):"); numero = int(numero[:-1])
    
        print(conversorDecimalBinario(numero))
        finalizado=True
        
    else:
        numero = input("Introduce un número decimal o binario correctamente (10100101b || 123d):")