'''
Created on 23 nov 2022

@author: raulh
'''

def isPrime(num):
    prime=False
    divisores=0
    
    while num<=0:
        num=int(input("Please, it must be a number greater than 0: "))
    
    if num==1:
        prime=True; return prime
    else:
        for i in range(1,num):
            if num%i==0:
                divisores = divisores +1
        
        if divisores==1:
            prime=True
    return prime

n=int(input("Please, input a number: "))
print("Is a prime number?:",isPrime(n))