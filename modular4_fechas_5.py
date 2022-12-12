'''
Created on 11 dic 2022

@author: raulh
'''
mes = 12
anyo = 2022
  
month = {1:'Enero', 2:'Febrero', 3:'Marzo', 4:'Abril', 5:'Mayo', 6:'Junio', 7:'Julio', 8:'Agosto', 9:'Septiembre', 10:'Octubre', 11:'Noviembre', 12:'Diciembre'} 
   
dia =(anyo-1)% 400
dia = (dia//100)*5 + ((dia % 100) - (dia % 100)//4) + ((dia % 100)//4)*2
dia = dia % 7
  
noBisiesto =[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 
bisiesto =[31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 
s = 0
  
if anyo%4 ==0:
    for i in range(mes-1): 
        s+=bisiesto[i]
else: 
    for i in range(mes-1): 
        s+=noBisiesto[i]
  
dia+=s%7
dia=dia%7
   
space='' 
space=space.rjust(2, ' ') 
  
print(month[mes], anyo) 
print('Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa', 'Do') 
  
if mes == 2: 
    if anyo % 4 == 0: 
        p = 30
    else: 
        p = 29
    for i in range(1,p + dia): 
        if i<= dia: 
            print(space, end =' ') 
        else: 
            print("{:02d}".format(i-dia), end =' ') 
            if (i)%7==0: 
                print()
elif mes==9 or mes==4 or mes==6 or mes==11:  
    for i in range(1,31 + dia): 
        if i<= dia: 
            print(space, end =' ') 
        else: 
            print("{:02d}".format(i-dia), end =' ') 
            if (i)%7==0: 
                print() 
else: 
    for i in range(1,32 + dia): 
        if i<= dia: 
            print(space, end =' ') 
        else: 
            print("{:02d}".format(i-dia), end =' ') 
            if (i)%7==0: 
                print() 