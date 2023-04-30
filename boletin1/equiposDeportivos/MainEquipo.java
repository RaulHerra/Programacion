package colecciones.com.colecciones.boletin1.equiposDeportivos;

import java.util.HashSet;
import java.util.Set;

public class MainEquipo {

	public static void main(String[] args) {
		Alumno jc = new Alumno("Juan carlos","1234567890");
		Alumno joc = new Alumno("Jose carlos","123456789");
		Alumno ja = new Alumno("Juan Angel","12345678");
		Alumno c = new Alumno("Carlos","1234567");
		Alumno m = new Alumno("Manuel","123456");
		

		Set<Alumno> reck=new HashSet<>();
		reck.add(jc);
		reck.add(joc);
		reck.add(ja);
		
		Set<Alumno> sha=new HashSet<>();
		sha.add(c);
		sha.add(m);
		
		//Se añaden alumnos a los equipos
		Equipo reckless = new Equipo("Reckless Team", reck);
		Equipo shadow = new Equipo("Dragon Shadow Team", sha);
		
		//Se añade un alumno que ya tiene y otro que no tiene
		//Salta la excepcion
		try {
			shadow.anyadirAlumno(c);
		} catch (AlumnoException e) {
			e.printStackTrace();
		}
		//No salta la excepcion
		try {
			shadow.anyadirAlumno(ja);
		} catch (AlumnoException e) {
			e.printStackTrace();
		}
		
		//Se borra un alumno que tiene y otro que no tiene
		//Salta la excepcion
		try {
			reckless.borrarAlumno(c);
		} catch (AlumnoException e) {
			e.printStackTrace();
		}
		//No salta la excepcion
		try {
			reckless.borrarAlumno(jc);
		} catch (AlumnoException e) {
			e.printStackTrace();
		}
		
		//Unimos ambos equipos para mostrarlos
		System.out.println("Unión");
		System.out.println(reckless.unionDeEquipos(shadow)); /*Imprime todos los jugadores de 
																ambos equipos sin repetir jugadores*/
		//Ahora se muestran por separado
		System.out.println("Mostrar equipos");
		System.out.println(reckless.mostrarAlumnos());
		System.out.println(shadow.mostrarAlumnos());
		
		//Ahora devolveremos alumnos de ambos equipos
		System.out.println("Devolver alumno");
		System.out.println(reckless.devolverAlumno(c)); //Devuelve null
		System.out.println(shadow.devolverAlumno(c));
		
		//Se muestran los alumnos que pertenecen a ambos equipos
		System.out.println("Intersección");
		System.out.println(reckless.interseccionDeEquipos(shadow));
		
		//toString de equipo
		System.out.println("toString()");
		System.out.println(reckless.toString());
	}
}
