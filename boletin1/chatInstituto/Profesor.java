package colecciones.com.colecciones.boletin1.chatInstituto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Profesor extends Persona{

	public Profesor(String nombre, LocalDate fechaNacimiento) {
		super(nombre, fechaNacimiento);
	}
	
	public boolean enviarMensaje(Persona receptor, String texto) throws PersonaException {
		receptor.recibirMensaje(new Mensaje(receptor.ultimoMensajeRecibido++, this,
				receptor, texto, LocalDateTime.now().toString()));;
		return true;
	}
}
