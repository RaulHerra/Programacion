'''
Created on 28 nov 2022

@author: raulh
'''

def buscarEscondida(palabra, cadena):
    aux=""
    for i in palabra:
        for j in cadena:
            if i==j and not(palabra==aux):
                aux+=i
    
    if palabra==aux:
        return True
    else:
        return False

palabraSecreta="Pedro".lower()
cadena="Passwevcsqdjklrxyzo".lower()

print(f"Se encuentra la palabra '{palabraSecreta}' en {cadena}?: {buscarEscondida(palabraSecreta, cadena)}")