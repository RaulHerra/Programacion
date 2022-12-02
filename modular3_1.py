'''
Created on Nov 25, 2022

@author: raulh
'''
   
def charactersInString(string, cha):
    counter=0
    for i in string.lower():
        if i.lower()==cha.lower():
            counter+=1
    return counter
string="Sarandonga"
cha="a"
print(f"The string has {charactersInString(string, cha)} times the character '{cha}'")