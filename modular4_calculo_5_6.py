'''
Created on 11 dic 2022

@author: raulh
'''
from src.Python.modular4.modular4_calculo_1_2_3_4 import extractDivisors, lcm

def leer_fraccion():
    fraccion=input("Introduzca su fraccion (formato = n/d): ")
    while not("/" in fraccion):
        fraccion=input("Introduzca su fraccion con el formato correcto (n/d): ")
    numerador, denominador = separarComponentes(fraccion)
    fraccion=simplificar_fraccion(numerador, denominador)
    print(f"{fraccion} añadida a mis fracciones")
    return fraccion
        
def escribir_fraccion(lista, posicion=""):
    if posicion=="":
        return lista
    else:
        return lista[posicion]
    
def calcular_mcd(n1,n2):
    divisores1=extractDivisors(n1)
    divisores2=extractDivisors(n2)
    maximoComunDivisor=1
    
    for i in divisores1:
        for j in divisores2:
            if i==j:
                maximoComunDivisor=i
    return maximoComunDivisor

def simplificar_fraccion(numerador, denominador):
    if numerador==denominador:
        return 1
    else:
        num=calcular_mcd(numerador, denominador)
        
        numerador=str(int(numerador/num)); denominador=str(int(denominador/num))
        fraccion=numerador+"/"+denominador
    return fraccion

def sumar_fracciones(fraccion1, fraccion2):
    numerador1, denominador1 = separarComponentes(fraccion1)
    numerador2, denominador2 = separarComponentes(fraccion2)
    
    if denominador1==denominador2:
        numeradorFinal=numerador1+numerador2
        denominadorFinal=denominador1
    else:
        denominadorFinal=lcm(denominador1, denominador2)
        numeradorFinal=(numerador1*(denominadorFinal//denominador1))+(numerador2*(denominadorFinal//denominador2))
    fraccionFinal=simplificar_fraccion(numeradorFinal, denominadorFinal)
    return fraccionFinal

def restar_fracciones(fraccion1,fraccion2):
    numerador1, denominador1 = separarComponentes(fraccion1)
    numerador2, denominador2 = separarComponentes(fraccion2)
    
    if denominador1==denominador2:
        numeradorFinal=numerador1-numerador2
        denominadorFinal=denominador1
    else:
        denominadorFinal=lcm(denominador1, denominador2)
        numeradorFinal=(numerador1*(denominadorFinal//denominador1))-(numerador2*(denominadorFinal//denominador2))
    fraccionFinal=simplificar_fraccion(numeradorFinal, denominadorFinal)
    return fraccionFinal
def multiplicar_fracciones(fraccion1, fraccion2):
    numerador1, denominador1 = separarComponentes(fraccion1)
    numerador2, denominador2 = separarComponentes(fraccion2)
    
    numeradorFinal=numerador1*numerador2
    denominadorFinal=denominador1*denominador2
    fraccionFinal=simplificar_fraccion(numeradorFinal, denominadorFinal)
    return fraccionFinal
def dividir_fracciones(fraccion1, fraccion2):
    numerador1, denominador1 = separarComponentes(fraccion1)
    numerador2, denominador2 = separarComponentes(fraccion2)
    
    numeradorFinal=numerador1*denominador2
    denominadorFinal=denominador1*numerador2
    fraccionFinal=simplificar_fraccion(numeradorFinal, denominadorFinal)
    return fraccionFinal

#Funciones auxiliares
def separarComponentes(fraccion):
    for i in range(len(fraccion)):
        if fraccion[i]=="/":
            numerador=int(fraccion[:i])
            denominador=int(fraccion[i+1:])
    return numerador, denominador

def SolicitarDatos(misFracciones):
    fraccion1=int(input("Introduzca la posición de la primera fracción: "))
    while fraccion1>=len(misFracciones) or fraccion1<0:
        fraccion1=int(input(f"Introduzca una posición correcta (0-{len(misFracciones)-1}): "))
    fraccion1=misFracciones[fraccion1]
    
    fraccion2=int(input("Introduzca la posición de la segunda fracción: "))
    while fraccion2>=len(misFracciones) or fraccion2<0:
        fraccion2=int(input(f"Introduzca una posición correcta (0-{len(misFracciones)-1}): "))
    fraccion2=misFracciones[fraccion2]
    return fraccion1, fraccion2

def main():
    menu='''    1.Leer y simplicar fracción
    2.Escribir fracción
    3.Calcular maximo común divisor
    4.Simplificar fracción
    5.Sumar fracciones
    6.Restar fracciones
    7.Multiplicar fracciones
    8.Dividir fracciones
    9.Mostrar mis fracciones
    10.Cerrar programa'''
    print(menu)
    opcion=int(input("Opción: "))
    misFracciones=[]
    
    while opcion!=10:
        if opcion==1:
            misFracciones.append(leer_fraccion())
        elif opcion==2 and not(misFracciones==[]):
            posicion=int(input("Introduzca la posición que desea ver: "))
            while posicion<0 or posicion>=len(misFracciones):
                posicion=int(input(f"Introduzca una posición correcta (0-{len(misFracciones)-1}): "))
            print(escribir_fraccion(misFracciones, posicion))
        elif opcion==3 and not(misFracciones==[]):
            pass
        elif opcion==4 and not(misFracciones==[]):
            pass
        elif opcion==5 and len(misFracciones)>=2:
            fraccion1, fraccion2 = SolicitarDatos(misFracciones)
            print(f"El resultado de la suma entre {fraccion1} y {fraccion2} es: {sumar_fracciones(fraccion1, fraccion2)}")
            
        elif opcion==6 and len(misFracciones)>=2:
            print("Tenga cuidado con el orden")
            fraccion1, fraccion2 = SolicitarDatos(misFracciones)
            print(f"El resultado de la resta entre {fraccion1} y {fraccion2} es: {restar_fracciones(fraccion1, fraccion2)}")

        elif opcion==7 and len(misFracciones)>=2:
            fraccion1, fraccion2 = SolicitarDatos(misFracciones)
            print(f"El resultado de la multiplicacion entre {fraccion1} y {fraccion2} es: {multiplicar_fracciones(fraccion1, fraccion2)}")

        elif opcion==8 and len(misFracciones)>=2:
            fraccion1, fraccion2 = SolicitarDatos(misFracciones)
            print(f"El resultado de la división entre {fraccion1} y {fraccion2} es: {dividir_fracciones(fraccion1, fraccion2)}")

        elif opcion==9:
            print(misFracciones)
        elif opcion==10:
            print("Cerrando programa")
        else:
            print("Esa opción no existe")
        print(menu)
        opcion=int(input("Opción: "))
if __name__=="__main__":
    main()