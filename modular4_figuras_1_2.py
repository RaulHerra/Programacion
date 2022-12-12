'''
Created on 11 dic 2022

@author: raulh
'''

def calcularAreaCirculo(radio):
    pi=3.14
    return pi*(radio**2)

def calcularPerimetroCirculo(radio):
    pi=3.14
    return 2*pi*radio

def main():
    opciones='''    1.Calcular área de un circulo
    2.Calcular perimetro de un circulo
    3.Cerrar programa'''
    print(opciones)
    opcion=int(input("Opción: "))
    
    while opcion!=3:
        if opcion==1:
            radio=float(input("Introduzca el radio: "))
            print(f"El area es {calcularAreaCirculo(radio)}")
        elif opcion==2:
            radio=float(input("Introduzca el radio: "))
            print(f"El perimetro es {calcularPerimetroCirculo(radio)}")
        elif opcion==3:
            print("Cerrando programa...")
        else:
            print("Opción incorrecta")
        print(opciones)
        opcion=int(input("Opción: "))
    
if __name__=="__main__":
    main()