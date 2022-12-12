'''
Created on 7 dic 2022

@author: raulh
'''
def crearUsuario():
    nombre=input("Introduzca el nombre de usuario: ")
    contrasenya=input("Introduzca su contraseña: ")
    valorarContrasenya(contrasenya)
    nuevaCuenta=nombre+"/"+contrasenya
    return nuevaCuenta

def valorarContrasenya(contrasenya):
    asegurar=input("Introduzca nuevamente la contraseña: ")
    while not(asegurar==contrasenya):
        asegurar=input("Las contraseñas no son iguales, introduzcalá nuevamente: ")
        
def mostrarUsuarios(usuarios):
    usuariosSinContrasenya=[]
    for i in usuarios:
        for j in range(len(i)):
            if i[j]=="/":
                usuariosSinContrasenya.append(i[:j])
    return usuariosSinContrasenya

def obtenerContrasenyaUsuario(usuarios, usuario, contrasenya):
    contador=-1
    for i in mostrarUsuarios(usuarios):
        contador+=1
        if usuario==i:
            for j in range(len(usuarios[contador])):
                if usuarios[contador][j]=="/":
                    contrasenyaReal=usuarios[contador][j+1:]
            if contrasenya==contrasenyaReal:
                return True
            else:
                return False
def main():
    #Hay un total de 11 usuarios si contamos a root como uno
    usuarios=["root/root","","","","","","","","","",""]
    menu='''    1.Crear usuario
    2.Iniciar sesión
    3.Mostrar usuarios'''
    inicioValido=False
    contadorUsers=1
    usuariosBloqueados=[]
    
    print(menu)
    seleccion=int(input("Opción: "))
        
    while inicioValido==False:
        if seleccion==1:
            if contadorUsers!=11:
                usuarios[contadorUsers]=crearUsuario()
                contadorUsers+=1
            else:
                print("Se ha alcanzado el numero máximo de usuarios")
        elif seleccion==2:
            usuario=input("Introduzca su usuario: ")
            if usuario in mostrarUsuarios(usuarios) and not(usuario in usuariosBloqueados):
                contrasenya=input("Introduzca su contraseña: ")
                contador=0
                while inicioValido==False and contador!=4:
                    if obtenerContrasenyaUsuario(usuarios, usuario, contrasenya):
                        inicioValido=True
                    else:
                        contador+=1
                        print("Contraseña incorrecta")
                    if inicioValido==False:
                        contrasenya=input(f"Introduzca su contraseña ({contador}/3): ")
                if contador==4:
                    usuariosBloqueados.append(usuario)
            else:
                print("Error, ese usuario no existe o está bloqueado")
        elif seleccion==3:
            print("+++++++++++++++++++++++++++++++++++")
            print(mostrarUsuarios(usuarios[1:]))
            print("+++++++++++++++++++++++++++++++++++")
        else:
            print("Opción incorrecta")
        if not(inicioValido):
            print("")
            print(menu)
            seleccion=int(input("Opción: "))
        
    menu='''    1.Crear usuario
    2.Mostrar usuarios
    3.Cerrar programa'''
    print(f"Inicio de sesión correcto, bienvenido {usuario}")
    print(menu)
    seleccion=int(input("Opción: "))
    
    while seleccion!=3:
        if seleccion==1:
            if contadorUsers!=11:
                usuarios[contadorUsers]=crearUsuario()
                contadorUsers+=1
            else:
                print("Se ha alcanzado el numero máximo de usuarios")
        elif seleccion==2:
            print("+++++++++++++++++++++++++++++++++++")
            print(mostrarUsuarios(usuarios[1:]))
            print("+++++++++++++++++++++++++++++++++++")

        else:
            print("Opción incorrecta")
        print(menu)
        seleccion=int(input("Opción: "))
        
    print("Cerrando programa")
if __name__=="__main__":
    main()