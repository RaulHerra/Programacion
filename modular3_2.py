'''
Created on Nov 25, 2022

@author: raulh
'''

def myLowers(cha):
    if cha=="a" or cha=="b" or cha=="c" or cha=="d" or cha=="e" or cha=="f" or cha=="g" or cha=="h" or cha=="i" or cha=="j" or cha=="k" or cha=="l" or cha=="m" or cha=="n" or cha=="ñ" or cha=="o" or cha=="p" or cha=="q" or cha=="r" or cha=="s" or cha=="t" or cha=="u" or cha=="v" or cha=="w" or cha=="x" or cha=="y" or cha=="z" or cha=="á" or cha=="é" or cha=="í" or cha=="ó" or cha=="ú" or cha=="ç":
        return True
    else:
        return False

def lowCaseInString(string):
    counter=0
    for i in string:
        if myLowers(i)==True:
            counter+=1
    return counter
string="PUM Ya está aquí la guerra"
print(f"This string has {lowCaseInString(string)} low characters")