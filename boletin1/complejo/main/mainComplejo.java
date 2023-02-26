package boletin1.complejo.main;
import boletin1.complejo.model.Complejo;
import java.util.Scanner;

public class mainComplejo { //Ejercicio 5
	
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        Complejo complejo1, complejo2, resultado;
        String menu="Menú:\n1.Sumar complejos\n2.Restar complejos\n3.Salir";
        
        while (opcion != 3) {
            System.out.println(menu);
            System.out.print("Seleccione una opción: ");
            opcion = Integer.valueOf(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Introduzca la parte real del primer número complejo: ");
                    double real1 = Double.valueOf(sc.nextLine());
                    System.out.print("Introduzca la parte imaginaria del primer número complejo: ");
                    double imaginaria1 = Double.valueOf(sc.nextLine());
                    complejo1 = new Complejo(real1, imaginaria1);

                    System.out.print("Introduzca la parte real del segundo número complejo: ");
                    double real2 = Double.valueOf(sc.nextLine());
                    System.out.print("Introduzca la parte imaginaria del segundo número complejo: ");
                    double imaginaria2 = Double.valueOf(sc.nextLine());
                    complejo2 = new Complejo(real2, imaginaria2);

                    resultado = complejo1.suma(complejo2);
                    System.out.println("El resultado de la suma es: " + resultado.mostrar());
                    break;

                case 2:
                    System.out.print("Introduzca la parte real del primer número complejo: ");
                    real1 = Double.valueOf(sc.nextLine());
                    System.out.print("Introduzca la parte imaginaria del primer número complejo: ");
                    imaginaria1 = Double.valueOf(sc.nextLine());
                    complejo1 = new Complejo(real1, imaginaria1);

                    System.out.print("Introduzca la parte real del segundo número complejo: ");
                    real2 = Double.valueOf(sc.nextLine());
                    System.out.print("Introduzca la parte imaginaria del segundo número complejo: ");
                    imaginaria2 = Double.valueOf(sc.nextLine());
                    complejo2 = new Complejo(real2, imaginaria2);

                    resultado = complejo1.resta(complejo2);
                    System.out.println("El resultado de la resta es: " + resultado.mostrar());
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                    break;
            }
        }
	}
}
