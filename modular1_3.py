'''
Created on 10 nov 2022

@author: raulh
'''

def validarBisiesto(validado):
    bi=False
    if validado%4==0 and (validado%100!=0 or validado%400==0):
        bi=True
    return bi

def validarFecha(validado, mesConcreto):
    print("Para el mes",mesConcreto,"el día",validado,"no existe")
    validado = int(input("Por favor introduzca un día válido: "))
    return validado

dia=1
meses = ["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agoso","Septiembre","Octubre","Noviembre","Diciembre"]
bisiesto=False

while dia>=0:
    print("Para detener el programa introduzca un día negativo")
    dia = int(input("Introduzca el día: "))
    while dia==0 or dia>31:
        dia = int(input("Introduzca un día válido: "))
    if dia<0:
        pass
    else:
        
    
        mes = int(input("Introduzca el mes: "))
        while mes<=0 or mes>12:
            mes = int(input("Introduzca un mes válido: "))
        mesFinal=meses[mes-1]
        while mes==2 and dia>29:
            dia = validarFecha(dia, mesFinal)
        
        anyo = int(input("Introduzca el año: "))
        while anyo<0:
            anyo = int(input("Introduzca un año válido: "))
        
        bisiesto = validarBisiesto(anyo)
        
        if bisiesto==False:
            while dia==29 and mes==2:
                dia = int(input("El año introducido no es bisiesto y el dia es 29 en febrero, introduzca otro día: "))
        while (dia<=0 or 31<dia and (mes==1 or mes==3 or mes==5 or mes==7 or mes==8 or mes==10 or mes==12)) or (dia<=0 or 30<dia and (mes==4 or mes==6 or mes==9 or mes==11)):
            dia = validarFecha(dia, mesFinal)
        print("La fecha en formato largo es",dia,"de",mesFinal,"del",anyo)
        print("")