'''
Created on 24 nov 2022

@author: raulh
'''

def getPrimeDivisors(num):
    div=0
    primes = []
    for i in range(1,num):
        if num%i==0: 
            div=0
            for j in range(1,i):
                if i%j==0:
                    div+=1
            if div==1:
                primes.append(i)
                
    return primes

n=int(input("Please input a number: "))
print(getPrimeDivisors(n))