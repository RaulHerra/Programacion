package com.persona.main;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import com.persona.model.*;

public class MainPersona {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		/*Genero generoIntroducido=null;
		System.out.print("Introduzca el genero: ");
		do {
			try {
				generoIntroducido=Genero.valueOf(sc.nextLine().toUpperCase());
			}catch(Exception e) {
				System.out.print("Introduzca un genero correcto: ");
			}
		}while(generoIntroducido==null);
		
		LocalDate fechaNacimiento=null;
		int dia=-1, mes=-1, anyo=-1;
		do {
			try {
				System.out.print("Introduzca el dia: "); 
				dia=Integer.valueOf(sc.nextLine());
				System.out.print("Introduzca el mes: "); 
				mes=Integer.valueOf(sc.nextLine());
				System.out.print("Introduzca el año: "); 
				anyo=Integer.valueOf(sc.nextLine());
				
				fechaNacimiento=LocalDate.of(anyo,mes,dia);
			}catch(Exception e) {
				System.out.println("Formato incorrecto: ");
				dia=-1; mes=-1; anyo=-1;
			}
		}while(dia==-1 && mes==-1 && anyo==-1);*/
		
		LocalDate fechaNacimiento=LocalDate.of(2004, 05, 10);
		
		Persona p1 = new Persona("Antonio","Sánchez",Genero.HOMBRE,fechaNacimiento);
		Persona p2 = new Persona("Maria","Sánchez",Genero.MUJER,fechaNacimiento);
		Persona p3 = new Persona("Anton","Sánchez",Genero.HOMBRE,fechaNacimiento);
		Persona p4 = new Persona("Antonia","Sánchez",Genero.MUJER,fechaNacimiento);
		
		Persona[] grupo = {p1,p2,p3,p4};

		System.out.println(Arrays.toString(grupo));

		Arrays.sort(grupo);
		
		System.out.println(Arrays.toString(grupo));
	}
}
