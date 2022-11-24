'''
Created on 18 nov 2022

@author: raulh
'''

def computeFactorial(num):
    fact = 1
    
    if num >= 0:
        while(num>1):
            fact *= num
            num -= 1
    else: 
        fact=None
    return fact

number = int(input("Insert a number: "))
print("The factorial is",computeFactorial(number))