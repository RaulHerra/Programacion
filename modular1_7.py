'''
Created on 11 nov 2022

@author: raulh
'''

def encajan(f1, f2):
    f1pt1=int(f1[1])
    f1pt2=int(f1[4])
    f2pt1=int(f2[1])
    f2pt2=int(f2[4])
    
    if f1pt1==f2pt1 or f1pt1==f2pt2 or f2pt1==f1pt2 or f2pt2==f1pt2:
        encaja=True
    else:
        encaja=False
    return encaja
    
ficha1=[]
ficha2=[]
cara=0

while cara!=2:
    ficha1.append(int(input(f"Introduzca el {cara+1}º valor de la primera ficha: ")))
    while ficha1[cara]<0 or 6<ficha1[cara]:
        ficha1[cara]=(int(input(f"Introduzca un valor valido (0-6): ")))
    cara+=1

cara=0 
while cara!=2:
    ficha2.append(int(input(f"Introduzca el {cara+1}º valor de la segunda ficha: ")))
    while ficha2[cara]<0 or 6<ficha2[cara]:
        ficha2[cara]=(int(input(f"Introduzca un valor valido (1-6): ")))
    cara+=1

ficha1Texto=str(ficha1)
ficha2Texto=str(ficha2)

print(f"¿Encajan?: {encajan(ficha1Texto, ficha2Texto)}")
