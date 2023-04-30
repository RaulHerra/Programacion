package colecciones.com.colecciones.boletin1.historial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainHistorial {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion=0;
		Usuario canelita = new Usuario("Canelita");
		String menu = "1.Consultar página\n2.Consultar historial completo\n3.Consultar historial de "
				+ "un dia\n4.Borrar historial\n5.Borrar visitas a una página\n6.Salir";
		do {
			System.out.println(menu);
			System.out.print("Opción: "); 
			try{
				opcion=Integer.valueOf(sc.nextLine());
			}catch(Exception e) {
				System.err.println("Valor no válido");
			}
			
			switch (opcion) {
				case 1:
					System.out.print("Introduzca el nombre de la página y acto seguido la URL: ");
					PaginaWeb pw = new PaginaWeb(sc.nextLine(), sc.nextLine());
					canelita.consultarHistorial().add(pw);
					break;
				case 2:
					System.out.println(canelita.consultarHistorial());
					break;
				case 3:
					int dia=1, mes=1;
					boolean datosValidos=true;
					//Solicitamos los datos
					System.out.print("Introduzca el día del mes: ");
					try {
						dia = Integer.valueOf(sc.nextLine());
					}catch(Exception e) {
						System.err.println("Dato inválido");
						datosValidos=false;
					}
					System.out.print("Introduzca el mes (En numero): ");
					if(datosValidos) {
						try {
							mes = Integer.valueOf(sc.nextLine());
						}catch(Exception e) {
							System.err.println("Dato inválido");
							datosValidos=false;
						}
					}
					if(datosValidos) {
						System.out.println(canelita.consultarHistorialDia(LocalDate.of(LocalDate.now().getYear(), mes, dia)));
					}
					break;
				case 4:
					canelita.borrarHistorial();
					break;
				case 5:
					System.out.print("Introduzca el nombre de la página y acto seguido la URL: ");
					canelita.borrarVisitasPagina(sc.nextLine(),sc.nextLine());
					break;
				case 6:
					System.out.println("Adeu");
					break;
				default:
					System.err.println("Has cometido un error");
			}
		}while(opcion!=6);
	}
	
	public static boolean esBisiesto(int anyo) {
	    boolean bisiesto = false;
		if (anyo % 4 == 0) {
	        if (anyo % 100 == 0) {
	            if (anyo % 400 == 0) {
		            bisiesto=true;
	            } else {
		            bisiesto=false;
	            }
	        } else {
	            bisiesto= true;
	        }
	    }
		return bisiesto;
	}
}
