'''
Created on 2 dic 2022

@author: raulh
'''

def sustituir(v, n, mensaje):
    for i in range(len(mensaje)):
        if not(i>=len(mensaje)):
            if mensaje[i]==v[0]:
                for j in range(len(v)):
                    if mensaje[(i+j)]==v[j]:
                        cambiar=True
                    else:
                        cambiar=False
                
                if cambiar==True:
                    if len(v)>len(n):
                        dif=len(v)-len(n)
                        mensaje=mensaje[:i]+n+mensaje[i+(len(n)+dif):]
                    elif len(v)<len(n):
                        dif=len(v)-len(n)
                        mensaje=mensaje[:i]+n+mensaje[i+(len(n)+dif):]
                    else:
                        mensaje=mensaje[:i]+n+mensaje[i+(len(n)):]
    return mensaje


#Ejemplo de palabraNueva>palabraVieja
palabraVieja="perro"
palabraNueva="gato"
mensaje="Me encantan los perros, los perros son maravillosos, me fascinan los perros. Tengo cuatro perros y quiero un quinto"


print(sustituir(palabraVieja, palabraNueva, mensaje))

#Ejemplo de palabraNueva<palabraVieja
palabraVieja="Manuel"
palabraNueva="Gallardo"
mensaje="Manuel no viene a clase, Manuel gasta una plaza y a Evelio no le dan la plaza de Manuel"

print("")
print(sustituir(palabraVieja, palabraNueva, mensaje))

#Ejemplo de palabraNueva==palabraVieja
palabraVieja="cinco"
palabraNueva="siete"
mensaje="cinco euros costaba el helado y yo cinco euros no tenía"

print("")
print(sustituir(palabraVieja, palabraNueva, mensaje))