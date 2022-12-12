'''
Created on 11 dic 2022

@author: raulh
'''

def diferenciaDesdeInicioDelDia(hora, minuto, segundo):
    return ((hora*60+minuto)*60+segundo)

def diferenciaEntreDos(hora1, minuto1, segundo1, hora2, minuto2, segundo2):
    momento1=diferenciaDesdeInicioDelDia(hora1, minuto1, segundo1)
    momento2=diferenciaDesdeInicioDelDia(hora2, minuto2, segundo2)
    segundosDiferencia=momento1-momento2
    
    if segundosDiferencia<0:
        return segundosDiferencia*-1
    else:
        return segundosDiferencia

def secondsToHour(seconds):
    hour=str(seconds//3600)
    seconds=seconds-int(hour)*3600
    
    minutes=str(seconds//60)
    seconds=seconds-int(minutes)*60
    
    seconds=str(seconds)
    result=hour+":"+minutes+":"+seconds
    return result

print(diferenciaDesdeInicioDelDia(19, 58, 44))
assert(diferenciaEntreDos(8, 0, 0, 14, 30, 0)==23400)
print(secondsToHour(23400))