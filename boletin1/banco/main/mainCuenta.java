package boletin1.banco.main;
import java.util.Scanner;
import boletin1.banco.model.Cuenta;

public class mainCuenta {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Cuenta corriente;
		do {
			System.out.print("Introduzca el saldo inicial: ");
			corriente = new Cuenta(Double.valueOf(sc.nextLine()));
		}while(corriente.getSaldo()<=0);
		
		String menu = "\n1. Hacer un reintegro.\r\n"
				+ "2. Hacer un ingreso.\r\n"
				+ "3. Consultar el saldo y el número de reintegros e ingresos realizados.\r\n"
				+ "4. Finalizar las operaciones.";
		char seleccion='0';
		do {
			System.out.println(menu);
			System.out.print("Opción: ");seleccion = sc.nextLine().charAt(0);
			
			switch(seleccion) {
				case '1':
					System.out.println("¿Qué cantidad desea retirar?: "); 
					double retirar;
					do{
						retirar=Double.valueOf(sc.nextLine());
					}while(retirar<=0);
					corriente.retirar(retirar);
					break;
				case '2':
					System.out.println("¿Qué cantidad desea retirar?: "); 
					double ingresar;
					do{
						ingresar=Double.valueOf(sc.nextLine());
					}while(ingresar<=0);
					corriente.ingresar(ingresar);					
					break;
				case '3':
					System.out.println("\nSaldo: "+corriente.getSaldo());
					System.out.println("Ingresos: "+corriente.getIngresos());
					System.out.println("Reintegros: "+corriente.getReintegros());
					break;
				case '4':
					System.out.println("¿Está segur@ de querer cerrar el programa? (S/N): ");
					char eleccion = sc.nextLine().toUpperCase().charAt(0);
					if(eleccion=='N') {seleccion='0';}
					break;
				default:
					System.out.println("Opción incorrecta");
					break;
			}
		}while(seleccion!='4');
		System.out.println("Cerrando programa...");
	}
}
