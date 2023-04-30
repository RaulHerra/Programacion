package colecciones.com.colecciones.boletin1.equiposDeportivos.ej8;

import java.util.Objects;

public class AlumnoEj8 implements Comparable<AlumnoEj8>{

	private String nombre;
	private String dni;
	private int edad;
	private char sexo;
	private String ciudad;
		
	public AlumnoEj8(String nombre, String dni, int edad, char sexo, String ciudad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.sexo = sexo;
		this.ciudad = ciudad;
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj && obj!=null;
		
		if (!sonIguales && obj instanceof AlumnoEj8) {
			AlumnoEj8 other = (AlumnoEj8) obj;
			sonIguales = Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);			
		}
		return sonIguales;
	}
	
	@Override
	public String toString() {
		return "El AlumnoEj8 " + nombre + " tiene el DNI " + dni + ".";
	}

	@Override
	public int compareTo(AlumnoEj8 otro) {
		return this.edad - otro.edad;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public int getEdad() {
		return edad;
	}	

	public String getCiudad() {
		return ciudad;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}
	
}