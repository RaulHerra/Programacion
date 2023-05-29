package dbconnect.main.java;

import java.sql.SQLException;
import java.util.Scanner;

import dbconnect.main.java.api.Connector;

public class MainApp {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String menu = "1.Mostrar información sobre los clientes\n"
				+ "2.Mostrar pedidos\n"
				+ "3.Añadir cliente\n"
				+ "4.Actualizar un cliente existente\n"
				+ "5.Eliminar cliente\n"
				+ "6.Añadir pedido\n"
				+ "7.Incluir Líneas de pedido a un pedido existente en estado Procesando\n"
				+ "8.Cerrar programa";
		int opcion = 0;
		Connector c = new Connector();
		try {
			c.connect();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		do{
			System.out.println(menu);
			System.out.print("Opcion: "); 
			//Comprobamos que el usuario introduzca un número
			try{
				opcion=Integer.parseInt(sc.nextLine());
			}catch(Exception e) {
				opcion=-1;
				System.err.println("Ha cometido un error");
			}
			
			switch(opcion) {
			case 1:
				System.out.println(c.hacerSelectClientes("select * from Cliente"));
				break;
			case 2:
				System.out.println(c.hacerSelectPedidos("select * from Pedido"));
				break;
			case 3:
				String nombre, apellidos, email, fechaNacimiento, genero;
				
				//Pedimos todos los datos deseados
				System.out.print("Introduzca el nombre: "); nombre=sc.nextLine(); 
				System.out.print("Introduzca los apellidos: "); apellidos=sc.nextLine(); 
				System.out.print("Introduzca el email: "); email=sc.nextLine();
				
				do{
					System.out.print("Introduzca la fecha de nacimiento (YYYY-MM-DD)");
					fechaNacimiento=sc.nextLine();
				}while(c.comprobarFechaValida(fechaNacimiento));
				
				do{
					System.out.print("Introduzca el genero \"M o F\"");
					genero = sc.nextLine().toUpperCase();
				}while(!genero.equals("F") && !genero.equals("M"));

				int id = c.hacerInsertCliente(nombre, apellidos, email, fechaNacimiento, genero);
				if(id!=-1) {
					System.out.println("Insert efectuado | id generada="+id);
				}else {
					System.err.println("Insert no efectuado");
				}
				break;
			case 4:
				System.out.println("Introduzca el id: ");
				String id_mod = sc.nextLine();
				System.out.println("Introduca la columna a modificar: ");
				String columna = sc.nextLine();
				System.out.println("Introduca el nuevo dato: ");
				c.hacerUpdate(id_mod, sc.nextLine(),columna);
				break;
			case 5:
				System.out.println("Introduzca la id: ");
				c.hacerDeleteCliente(sc.nextLine());
				break;
			case 6:
				String codigo, status, id_cliente;
				
				//Pedimos todos los datos deseados
				System.out.print("Introduzca el codigo del pedido: "); codigo=sc.nextLine(); 
				System.out.print("Introduzca el status: "); status=sc.nextLine().toUpperCase(); 
				System.out.print("Introduzca el idCliente: "); id_cliente=sc.nextLine();

				int idP = c.hacerInsertPedido(codigo, status, id_cliente);
				if(idP!=-1) {
					System.out.println("Insert efectuado | id generada="+idP);
				}else {
					System.err.println("Insert no efectuado");
				}
				break;
			case 7:
				String cod, nombreProducto, idPedido, cantidad, precio;
				
				//Pedimos todos los datos deseados
				System.out.print("Introduzca el codigo del pedido: "); cod=sc.nextLine(); 
				System.out.print("Introduzca el status: "); nombreProducto=sc.nextLine().toUpperCase(); 
				System.out.print("Introduzca el idCliente: "); idPedido=sc.nextLine();
				System.out.print("Introduzca la cantidad: "); cantidad=sc.nextLine(); 
				System.out.print("Introduzca el precio: "); precio=sc.nextLine(); 

				int idL = c.hacerInsertLinea(cod, nombreProducto, idPedido, cantidad, precio);
				if(idL!=-1) {
					System.out.println("Insert efectuado | id generada="+idL);
				}else {
					System.err.println("Insert no efectuado");
				}
				break;
			case 8:
				System.out.println("Saliendo del programa");
				break;
			default: 
				System.err.println("Opción no válida");
				break;
			}
		}while(opcion!=8);
	}
}