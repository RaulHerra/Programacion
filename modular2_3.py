'''
Created on 15 nov 2022

@author: raulh
'''

def isLeapYear(y):
    leap=False
    if y%4==0 and (y%100!=0 or y%400==0):
        leap=True
    return leap

def computeDaysInMonth(m):
    months=[31,28,31,30,31,30,31,31,30,31,30,31]
    if m<len(months):
        days=months[m]
    else:
        days=-1
    return days
    

year= int(input("Please insert a year: "))
while year<=0:
    year = int(input("Please insert a valid year (<0): "))
    
month= int(input("Please insert a month by its number: "))    
while year<0:
    month = int(input("Please insert a valid month (<0): "))    
    
if isLeapYear(year) and month==2:
    print("It has",computeDaysInMonth(month-1)+1,"days")
else:
    print("It has",computeDaysInMonth(month-1),"days")