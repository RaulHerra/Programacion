package colecciones.com.colecciones.boletin1.equiposDeportivos;

import java.util.Objects;

public class Alumno {
	
	private String nombre;
	private String dni;
	
	public Alumno(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return String.format("Alumno %s con DNI: %s", this.nombre, this.dni);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj != null && obj instanceof Alumno) {
			Alumno casteado = (Alumno)obj;
			
			sonIguales = casteado.dni.equals(this.dni);
		}
		return sonIguales;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre);
	}
}
