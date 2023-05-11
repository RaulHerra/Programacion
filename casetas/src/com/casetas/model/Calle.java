package com.casetas.model;

import java.util.Objects;

public class Calle {

	private String nombre;
	private int idCalle;
	
	public Calle(String nombre, int idCalle) {
		super();
		this.nombre = nombre;
		this.idCalle = idCalle;
	}
	
	public Calle(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCalle, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales= this==obj;
		
		if(!sonIguales && obj instanceof Calle) {
			Calle casteado = (Calle) obj;
			
			sonIguales=casteado.nombre.equals(this.nombre);
		}
		return sonIguales;
	}
}
