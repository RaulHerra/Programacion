package com.persona.model;
import java.time.LocalDate;

public class Persona implements Desplazable, Comparable<Persona>{

	private Genero genero;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	
	
	public Persona(String nombre, String apellidos, Genero genero, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
	}
	

	
	public Genero getGenero() {
		return genero;
	}


	@Override
	public void moverse() {
		System.out.println("Desplazandose ligeramente hacie la derecha");
		
	}


	@Override
	public void saltar() {
		System.out.println("Se ha roto un tobillo");
	}


	@Override
	public void agacharse() {
		System.out.println("Cuidado al levantarse");
	}


	@Override
	public void correr() {
		System.out.println("Empieza a correr, se cansa a los 13 segundos");
	}
	
	public int compareTo(Persona o) {
		int resultado = 0;
		if(this.genero.equals(Genero.MUJER) && o.genero.equals(Genero.HOMBRE)) {
			resultado = -1;
		}else
			if(this.genero.equals(Genero.HOMBRE) && o.genero.equals(Genero.MUJER)) {
				resultado = 1;
			}
		return resultado;
	}
	
	public String toString() {
		return this.nombre+" "+this.apellidos;
	}
}
