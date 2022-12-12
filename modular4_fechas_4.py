'''
Created on 11 dic 2022

@author: raulh
'''

def extraerDiaYMes(fecha):
    for i in range(len(fecha)):
        if fecha[i]=="/":
            dia=fecha[:i]
            mes=fecha[i+1:]
    return int(dia), int(mes)

def diferenciaFechas(dia1, mes1, dia2, mes2):
    diaFinal=dia1-dia2
    meses=[31,28,31,30,31,30,31,31,30,31,30,31]
    
    if diaFinal<0:
        diaFinal*=-1
    if mes1<mes2:
        diaFinal+=sum(meses[mes1-1:mes2-1])
    elif mes1>mes2:
        diaFinal+=sum(meses[mes2-1:mes1-1])
    return diaFinal

fecha1 = input("Introduzca la primera fecha (dd/mm): ")
while "/" not in fecha1:
    fecha1 = input("Introduzca una fecha correcta (dd/mm): ")
dia1, mes1 = extraerDiaYMes(fecha1)

fecha2 = input("Introduzca la segunda fecha (dd/mm): ")
while "/" not in fecha2:
    fecha2 = input("Introduzca una fecha correcta (dd/mm): ")
dia2, mes2 = extraerDiaYMes(fecha2)

print(diferenciaFechas(dia1, mes1, dia2, mes2))