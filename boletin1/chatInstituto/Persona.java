package colecciones.com.colecciones.boletin1.chatInstituto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Persona {

	private String nombre;
	private LocalDate fechaNacimiento;
	private List<Mensaje> bandeja;
	protected int ultimoMensajeRecibido=1;

	
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.bandeja = new ArrayList<Mensaje>();
	}

	public abstract boolean enviarMensaje(Persona receptor, String texto) throws PersonaException;
	
	public String leerBandeja() throws PersonaException {
		StringBuilder sb = new StringBuilder("");
		//Se comprueba que la bandeja no esté vacia, si lo está devuelve error
		if(!(getBandeja().isEmpty())) {
			for(Mensaje m : getBandeja()) {
				sb.append(m.toString());
			}
		}else {
			throw new PersonaException("No tiene mensajes en la bandeja de entrada");
		}
		return sb.toString();
	}
	
	public String leerBandejaOrdenadaPorNombre() throws PersonaException {
		StringBuilder sb = new StringBuilder("");
		//Se comprueba que la bandeja no esté vacia, si lo está devuelve error
		if(!(getBandeja().isEmpty())) {
			List<Mensaje> bandejatmp=getBandeja();
			
			Collections.sort(bandejatmp, Mensaje::compareTo);
			for(Mensaje m : bandejatmp) {
				sb.append(m.toString());
			}
		}else {
			throw new PersonaException("No tiene mensajes en la bandeja de entrada");
		}
		return sb.toString();
	}
	
	public void borrarMensaje(int numero) throws PersonaException{
		boolean mensajeSinBorrar=true;
		for(Mensaje m : getBandeja()) {
			if(m.getNumero()==numero) {
				getBandeja().remove(m);
				mensajeSinBorrar=false;
			}
		}
		//Si el mensaje no ha sido borrado, se da el error
		if(mensajeSinBorrar) {
			throw new PersonaException("Mensaje no encontrado");
		}
	}
	
	public String buscarPorFrase(String cadena) {
		StringBuilder sb = new StringBuilder("");
		for(Mensaje m : getBandeja()) {
			if(m.getTexto().contains(cadena)) {
				sb.append(m);
			}
		}
		return sb.toString();
	}

	public int getEdad() {
		return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}

	public List<Mensaje> getBandeja() {
		return bandeja;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void recibirMensaje(Mensaje mensaje) {
		this.bandeja.add(mensaje);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bandeja, fechaNacimiento, nombre, ultimoMensajeRecibido);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj != null && obj instanceof Mensaje) {
			Mensaje casteado = (Mensaje)obj;
			
			sonIguales = casteado.hashCode()==this.hashCode();
		}
		return sonIguales;
	}

	@Override
	public String toString() {
		return String.format("%s", this.nombre.toString());
	}
}