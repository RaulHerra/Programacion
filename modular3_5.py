'''
Created on 28 nov 2022

@author: raulh
'''

def palindrome(string):
    check=True
    i=0
    tmp=0
    tmpb=0
    while check and i+tmp<len(string):
        if string[i+tmp]==" ":
            tmp+=1
        if string[-(i+1+tmpb)]==" ":
            tmpb+=1
        if not(string[i+tmp].lower()==string[-(i+1+tmpb)].lower()):
            check=False
        i+=1
    return check

sentence="Dabale arroz a la zorra el abad"
print(f"The sentence is a palindrome?: {palindrome(sentence)}")