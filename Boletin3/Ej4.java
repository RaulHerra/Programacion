package Boletin3;
import java.util.Scanner;
import Boletin3.fecha.model.Fecha;
import java.lang.Exception;

public class Ej4 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", 
		  "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
		int dia=0, mes=0, anio=0;
		
		System.out.print("Introduce el día: ");
		do{
			try{
				dia = Integer.valueOf(sc.nextLine());
			}catch (Exception e) {
				System.out.println("Debe de ser un valor numérico");
			}
		}while(dia==0);
		
		System.out.print("Introduce el mes (1-12): ");
		do{
			try{
				mes = Integer.valueOf(sc.nextLine());
			}catch (Exception e) {
				System.out.println("Debe de ser un valor numérico");
			}
		}while(mes==0);
		System.out.print("Introduce el año: ");
		do{
			try{
				anio = Integer.valueOf(sc.nextLine());
			}catch (Exception e) {
				System.out.println("Debe de ser un valor numérico");
			}
		}while(anio==0);
		
		Fecha fecha = new Fecha(dia, mes, anio);
	
		if (fecha.esValida()) {
			System.out.println(fecha.pasarAformatoLargo(meses));
		}else{
			System.out.println("Fecha incorrecta.");
		}
	}
}