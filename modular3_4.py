'''
Created on 28 nov 2022

@author: raulh
'''

def myDigit(n):
    n=str(n)
    for i in n:
        if i=="0" or i=="1" or i=="2" or i=="3" or i=="4" or i=="5" or i=="6" or i=="7" or i=="8" or i=="9":
            digit=True
        else:
            digit=False
    return digit

def numberInString(string):
    counter=0
    for i in string:
        if myDigit(i)==True:
            counter+=1
    return counter

sentence='''Y el chiqui-chiqui se baila así:
1! EL BREIKINDANCE!
2! EL CRUSAÍTO
3! EL MAIQUELYASON
4! EL ROBOCOP!'''

print(f"The sentence has {numberInString(sentence)} numbers")