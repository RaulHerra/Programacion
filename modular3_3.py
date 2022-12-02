'''
Created on Nov 25, 2022

@author: raulh
'''

def myUppers(cha):
    if cha=="A" or cha=="B" or cha=="C" or cha=="D" or cha=="E" or cha=="F" or cha=="G" or cha=="H" or cha=="I" or cha=="J" or cha=="K" or cha=="L" or cha=="M" or cha=="N" or cha=="Ñ" or cha=="O" or cha=="P" or cha=="Q" or cha=="R" or cha=="S" or cha=="T" or cha=="U" or cha=="V" or cha=="W" or cha=="X" or cha=="Y" or cha=="Z" or cha=="Á" or cha=="É" or cha=="Í" or cha=="Ó" or cha=="Ú" or cha=="Ç":
        return True
    else:
        return False

def lowCaseInString(string):
    counter=0
    for i in string:
        if myUppers(i)==True:
            counter+=1
    return counter

string='''Y esa Juana sin Arco, ese Bill sin Gates
Aquella foto de aquel narco que viste de Beige
Y esa cabaña en el lago
Sé lo que hicisteis el último Verano'''

print(f"This string has {lowCaseInString(string)} upper characters")