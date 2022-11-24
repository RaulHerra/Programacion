'''
Created on 16 nov 2022

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

def getDayOfTheWeek(day, month, year):
    days=["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"]
    a = (14 - month) // 12
    y = year - a
    m = month + 12 * a - 2
    d = (day+y+y//4-y//100+y//400+(31*m)//12)%7
    
    return days[d]
    

year= int(input("Please insert a year: "))
while year<=0:
    year = int(input("Please insert a valid year (<0): "))
    
month= int(input("Please insert a month by its number: "))    
while year<0:
    month = int(input("Please insert a valid month (<0): "))    
    
day= int(input("Please insert the day: "))
while day<=0 and day>=computeDaysInMonth(month):
    day= int(input("Please insert a valid day: "))

print(f"This day is/was {getDayOfTheWeek(day, month, year)}")   