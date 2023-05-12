package com.casetas.model;

public class Caseta{

	private int id;
	private String titulo;
	private int numero;
	private int modulos;
	private String clase;
	
	public Caseta(int id, String titulo, int numero, int modulos, String clase) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numero = numero;
		this.modulos = modulos;
		this.clase = clase;
	}

	public int getNumero() {
		return numero;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getModulos() {
		return modulos;
	}

	public String getClase() {
		return clase;
	}
	@Override
	public String toString() {
		return String.format("Caseta: %s Número: %s", titulo, numero);
	}
	
	public void descenderCuandoBorrado() {
		this.numero-=this.modulos;
	}
}
