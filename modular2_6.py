'''
Created on 22 nov 2022

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
    
def myHexDigit(n):
    n=str(n)
    if n=="a" or n=="b" or n=="c" or n=="d" or n=="e" or n=="f":
        return True
    else:
        return False
    
def getNumberOfDigits(num):
    digits=0
    hexadecimal=False
    mensage=" and it seems to be an hexadecimal number"
    i=0
    number=True
    point=0
    
    for j in range(2):
        if num[j]=="-":
            num=num[-i+1:]
    
    while i<len(num) and number==True:
        if myDigit(num[i])==True or myHexDigit(num[i])==True:
            digits+=1
            if myHexDigit(num[i])==True:
                hexadecimal=True
        elif i==len(num)-1 or (num[i]=="." or num[i]==",") and point==0:
            point=1
        else:
            number=False
        i+=1
                
    if hexadecimal==True:
        return str(digits)+mensage
    else:
        if number==False:
            return None
        else:
            return digits

def main():
    n=input("Please, input one number (It can be decimal, binary, hexadecimal...): ").lower()
    print("This number has", getNumberOfDigits(n))
    
if __name__=="__main__":
    main()