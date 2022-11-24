'''
Created on 22 nov 2022

@author: raulh
'''

def powerIt(num, exp=0):
    return num**exp
    
    
num1=int(input("Insert the first number: "))
while num1<=0:
    num1=int(input("Insert the first number again (must be greater than 0): "))

option=""
while option!="Y" and option!="N":
    option=input("¿Do you want to input an exponent? (Y/n): ")[0].upper()

num2=-2
if option=="Y":
    while num2<=0:
        num2=int(input("Insert the exponent (must be greater than 0): "))
    print(powerIt(num1, num2))
else:
    print(powerIt(num1))