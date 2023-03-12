package Boletin3;
import java.util.Scanner;

public class Ej7 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		System.out.print("Introduce el número de alumnos: ");
		int numAlumnos=0;
		do {
			try {
				numAlumnos = Integer.valueOf(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Debe ser un valor numerico");
			}
		}while(numAlumnos<=0);
		        
		String[] nombres = new String[numAlumnos];
		int[] notas = new int[numAlumnos];
		    
		// Pide el nombre y la nota para cada alumno
		for (int i = 0; i < numAlumnos; i++) {
			System.out.print("Introduce el nombre del alumno " + (i+1) + ": ");
			nombres[i] = sc.nextLine();
			System.out.print("Introduce la nota del alumno " + (i+1) + ": ");
			do{
				try{
					notas[i] = Integer.valueOf(sc.nextLine());
				}catch(Exception e) {
					System.out.print("Debe de ser un valor númerico superior a 0: ");
				}
			}while(notas[i]<=0);
		}
		
		int opcion = 0;
		String menu="Elige una opción:\n1.Mostrar el nombre y la nota de los alumnos aprobados.\n2.Mostrar el nombre y la nota de los alumnos suspensos.\n3.Mostrar la nota media de la clase.\n4.Mostrar los alumnos que tienen más de una nota X.\n5.Mostrar el alumno con la nota máxima y mínima.\n6.Mostrar un listado ordenado de forma creciente por la nota.\n7.Salir";
		do {
			System.out.println(menu);
			opcion = Integer.valueOf(sc.nextLine());
			
			switch (opcion) {
			case 1: // Alumnos aprobados
				System.out.println("Alumnos aprobados:");
				for (int i = 0; i < numAlumnos; i++) {
					if (notas[i] >= 5) {
						System.out.println(nombres[i] + " - " + notas[i]);
					}
				}
				break;
			case 2: // Alumnos suspensos
				System.out.println("Alumnos suspensos:");
				for (int i = 0; i < numAlumnos; i++) {
					if (notas[i] < 5) {
						System.out.println(nombres[i] + " - " + notas[i]);
					}
				}
				break;                
			case 3: // Nota media de la clase
				int suma = 0;
				for (int i = 0; i < numAlumnos; i++) {
					suma += notas[i];
				}
				double media = suma / numAlumnos;
				System.out.println("La nota media de la clase es: " + media);
				break;
			                    
			case 4: // Alumnos con más nota X
				System.out.print("Introduce la nota: ");
				int notaX = 0;
				do {
					try {
						notaX=Integer.valueOf(sc.nextLine());
					}catch(Exception e) {
						System.out.println("Debe ser un dato numerico");
					}
				}while(notaX<=0);
				
				System.out.println("Alumnos con nota igual o superior a " + notaX + ":");
				for (int i = 0; i < numAlumnos; i++) {
					int contador = 0;
					for (int j = 0; j < numAlumnos; j++) {
						if (notas[i] >= notaX) {
							contador++;
						}
					}
					if (contador > 1) {
						System.out.println(nombres[i] + " - " + notas[i]);
					}
				}
				break;
			case 5: // Mostrar el alumno con la nota máxima y mínima
				String nombreAlumnoMax = "", nombreAlumnoMin = "";
				int notaMax = 0, notaMin = 10;
			
				// Recorremos el array de alumnos para encontrar la nota máxima y mínima
				for (int i = 0; i < numAlumnos; i++) {
					if (notas[i] > notaMax) {
						notaMax = notas[i];
						nombreAlumnoMax = nombres[i];
					}
					if (notas[i] < notaMin) {
						notaMin = notas[i];
						nombreAlumnoMin = nombres[i];
					}
				}
				System.out.println("Alumno con la nota máxima: " + nombreAlumnoMax + " con una nota de " + notaMax);
				System.out.println("Alumno con la nota mínima: " + nombreAlumnoMin + " con una nota de " + notaMin);
				break;
			case 6: // Mostrar un listado ordenado de forma creciente por la nota
				// Ordenamos los alumnos por nota
				for (int i = 0; i < numAlumnos - 1; i++) {
					for (int j = i + 1; j < numAlumnos; j++) {
						if (notas[i] > notas[j]) {
							// Intercambiamos las notas
							int tempNota = notas[i];
							notas[i] = notas[j];
							notas[j] = tempNota;
			    
							// Intercambiamos los nombres
							String tempNombre = nombres[i];
							nombres[i] = nombres[j];
							nombres[j] = tempNombre;
						}
					}
				}
			
				// Mostramos el listado ordenado
				System.out.println("Listado de alumnos ordenado por nota:");
				for (int i = 0; i < numAlumnos; i++) {
					System.out.println(nombres[i] + " - " + notas[i]);
				}
				break;
			case 7:
				System.out.println("Cerrando programa...");
				return;
			default:
				System.out.println("Opcion no encontrada");
			}
		}while(true);
	}
}