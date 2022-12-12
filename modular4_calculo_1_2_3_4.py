'''
Created on 11 dic 2022

@author: raulh
'''
#He pensado que era mejor idea meter los cuatro primeros en un mismo archivo .py para repasar las funciones
'''Exercise 1'''
def sumDigits(num):
    num=str(num)
    sum=0
    for i in num:
        sum+=int(i)
    return sum

'''Exercise 2'''
def gcd(n1,n2):
    dividers1=extractDivisors(n1)
    dividers2=extractDivisors(n2)
    
    for i in dividers1:
        for j in dividers2:
            if i==j:
                greatestCommonDivisor=i
    return greatestCommonDivisor
    
def extractDivisors(number):
    list=[]
    if number==1:
        list.append(1)
    else:
        for i in range(1, number):
            if number%i==0:
                list.append(i)
    return list

'''Exercise 3'''
def lcm(n1,n2):
    multiplesOfn1=calculateMultiples(n1, n2)
    multiplesOfn2=calculateMultiples(n2, n1)

    for i in range(1,len(multiplesOfn1)):
        for j in range(1,len(multiplesOfn2)):
            if multiplesOfn1[-i]==multiplesOfn2[-j]:
                leastCommonMultiple=multiplesOfn1[-i]
    return leastCommonMultiple

def calculateMultiples(number,numberOfMultiplies):
    list=[]
    for i in range(1, numberOfMultiplies+1):
        list.append(i*number)
    return list
'''Exercise 4'''
def calculationOccurs(n,i=1):
    counter=1
    finalNumber=n
    while counter<i:
        n=str(n)
        n+=n[0]
        n=int(n)
        finalNumber+=n
        counter+=1
    return finalNumber

def main():
    menu='''    1. modular4_2_1
    2. modular4_2_2
    3. modular4_2_3
    4. modular4_2_4
    5. Stop execution'''
    print(menu)
    option=int(input("Option: "))
    
    while option!=5:
        if option==1:
            num1=int(input("Input the number: "))
            print(sumDigits(num1))
        elif option==2:
            num1=int(input("Input the first number: "))
            num2=int(input("Input the second number: "))
            print(f"the GCD of {num1} and {num2} is {gcd(num1,num2)}")
        elif option==3:
            num1=int(input("Input the first number: "))
            num2=int(input("Input the second number: "))
            print(f"the LCM of {num1} and {num2} is {lcm(num1,num2)}")
        elif option==4:
            num1=int(input("Input the number: "))
            occurs=int(input("Input the occurs: "))
            print(f"result = {calculationOccurs(num1,occurs)}")
        elif option==5:
            print("Closing...")
        else:
            print("That's an incorrect option")
        print(menu)
        option=int(input("Option: "))

if __name__=="__main__":
    main()