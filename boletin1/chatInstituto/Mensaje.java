package colecciones.com.colecciones.boletin1.chatInstituto;

import java.util.Objects;

import colecciones.com.colecciones.boletin1.equiposDeportivos.Alumno;

public class Mensaje {

	private int numero;
	private Persona emisor;
	private Persona receptor;
	private String texto;
	private String fechaYHora;
	
	public Mensaje(int numero, Persona emisor, Persona receptor, String texto, String fechaYHora) {
		super();
		this.numero = numero;
		this.emisor = emisor;
		this.receptor = receptor;
		this.texto = texto;
		this.fechaYHora = fechaYHora;
	}
	
	@Override
	public String toString() {
		return String.format("Mensaje %s: De: %s \nTexto: %s \nFecha y hora: %s\n", numero, emisor, 
				texto, fechaYHora);
	}

	public int getNumero() {
		return numero;
	}

	public Persona getEmisor() {
		return emisor;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public int compareTo(Mensaje s2) {
		return this.emisor.getNombre().charAt(0)-s2.emisor.getNombre().charAt(0);
	}

	@Override
	public int hashCode() {
		return Objects.hash(emisor, fechaYHora, numero, receptor, texto);
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
}