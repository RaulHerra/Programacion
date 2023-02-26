package boletin1.maquinaCafe.main;

import java.util.Scanner;
import boletin1.maquinaCafe.model.MaquinaCafe;

public class mainCafe {

    static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
        MaquinaCafe maquina = new MaquinaCafe(50);
        Double dinero;
        
        String menu="Bienvenido a la máquina de café. ¿Qué desea tomar?\r\n"
        		+ "1. Café (1 euro)\r\n"
        		+ "2. Leche (0.8 euros)\r\n"
        		+ "3. Café con leche (1.5 euros)\r\n"
        		+ "4. Consultar estado de la máquina\r\n"
        		+ "5. Apagar máquina y salir";
        while (true) {
        	System.out.println(menu);
            System.out.print("Opcion: "); int opcion = Integer.valueOf(sc.nextLine());
            switch (opcion) {
                case 1:
                	System.out.print("Introduzca el dinero: "); dinero=Double.valueOf(sc.nextLine());
                    System.out.println(maquina.servirCafe(dinero));
                    break;
                case 2:
                	System.out.print("Introduzca el dinero: "); dinero=Double.valueOf(sc.nextLine());
                    System.out.println(maquina.servirLeche(dinero));
                    break;
                case 3:
                	System.out.print("Introduzca el dinero: "); dinero=Double.valueOf(sc.nextLine());
                    System.out.println(maquina.servirCafeConLeche(dinero));
                    break;
                case 4:
                    System.out.println(maquina.mostrarDepositos()+maquina.mostrarMonedero());
                    break;
                case 5:
                    System.out.println("Gracias por usar la máquina de café. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del 1 al 5.");
            }
        }
	}
}
