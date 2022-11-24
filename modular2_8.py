'''
Created on 24 nov 2022

@author: raulh
'''
from src.Python.modular2.modular2_6 import getNumberOfDigits
from src.Python.modular2.modular2_6 import myDigit


def solveSecondOrderEquation(a,b,c):
    x1=""
    x2=""
    resultado=None
   
    if a>0 and b>0 and c>0:
        x1=(-b + (((b**2)-4*a*c)**0.5))/2*a
        x2=(-b - (((b**2)-4*a*c)**0.5))/2*a
       
        resultado=f"La primera solución es {x1} y la segunda es {x2}."
    
    if myDigit(getNumberOfDigits(str(x1)))!=True and myDigit(getNumberOfDigits(str(x1)))!=True:
        return ("No tiene solución real")
    else:
        return resultado

a=3
b=5
c=1

print(solveSecondOrderEquation(a,b,c))