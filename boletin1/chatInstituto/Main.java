package colecciones.com.colecciones.boletin1.chatInstituto;

import java.time.LocalDate;

import colecciones.com.colecciones.boletin1.equiposDeportivos.AlumnoException;

public class Main {

	public static void main(String[] args) {
		Persona canelita = new Alumno("Canelita", LocalDate.of(2005, 10, 2));
		Persona johnny = new Alumno("Johnny",LocalDate.of(2002, 2, 14));
		Persona luz = new Profesor("Manoli",LocalDate.of(1994, 12, 18));
		Persona pedrito = new Profesor("Pedrito",LocalDate.of(1993, 4, 24));
		
		try {
			canelita.enviarMensaje(pedrito, "Y dale dale dale comba");
			johnny.enviarMensaje(canelita, "Relajate amigo");
			luz.enviarMensaje(johnny, "El Lunes faltaré a clase");
			canelita.enviarMensaje(johnny, "Quiero quiero que me digas si me amas");
		} catch (PersonaException e) {
			e.printStackTrace();
		}
		
		try {
			pedrito.enviarMensaje(johnny, "Debes entregar la tarea cuatro");
			System.out.println("Mensajes de johnny\n"+johnny.leerBandeja());
			pedrito.borrarMensaje(1);
		} catch (PersonaException e) {
			e.printStackTrace();
		}
		System.out.println("\nBuscando por frase en la bandeja de p2");
		System.out.println(pedrito.buscarPorFrase("dale"));
	}
}