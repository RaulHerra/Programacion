package boletin1.geometria.main;
import boletin1.geometria.model.Rectangulo;
import java.util.Scanner;

public class mainRectangulo {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		double ancho=0, longitud=0;
		
		do {
			System.out.print("Introduzca el ancho (0>ancho<20): "); ancho=Double.valueOf(sc.nextLine());
		}while(ancho<0 || ancho>20);
			
		do {
			System.out.print("Introduzca la longitud (0>longitud<20): "); longitud=Double.valueOf(sc.nextLine());
		}while(longitud<0 || longitud>20);
		
		Rectangulo rec = new Rectangulo(longitud,ancho);
		
		System.out.println(rec.calcularArea());
		System.out.println(rec.calcularPerimetro());
	}
}
