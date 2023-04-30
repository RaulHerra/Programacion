package colecciones.com.colecciones.boletin1.chatInstituto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Alumno extends Persona {

	public Alumno(String nombre, LocalDate fechaNacimiento) {
		super(nombre, fechaNacimiento);
	}

	public boolean enviarMensaje(Persona receptor, String texto) throws PersonaException {
		boolean mensajeEnviado=true;
		if(this.getEdad()<=18 && !(receptor instanceof Profesor)) {
			mensajeEnviado=false;
			throw new PersonaException("No se puede enviar un mensaje a otro alumno siendo "
					+ "menor");
		}else {
			receptor.recibirMensaje(new Mensaje(receptor.ultimoMensajeRecibido++, this,
					receptor, texto, LocalDateTime.now().toString()));
		}
		return mensajeEnviado;
	}
}
