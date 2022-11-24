'''
Created on 15 nov 2022

@author: raulh
'''

def isLeapYear(y):
    leap=False
    if y%4==0 and (y%100!=0 or y%400==0):
        leap=True
    return leap

year= int(input("Please insert a year: "))
while year<=0:
    year = int(input("Please insert a valid year (<0): "))
print("Is this year leap?:",isLeapYear(year))