'''
Created on 24 nov 2022

@author: raulh
'''

def isFriendNumber(num1, num2):
    div1=0
    div2=0
    for i in range(1,num1):
        if num1%i==0:
            div1+=i
    for i in range(1,num2):
        if num2%i==0:
            div2+=i
    
    if div1==num2 and div2==num1:
        return True
    else:
        return False

n1=220
n2=284
print(isFriendNumber(n1, n2))