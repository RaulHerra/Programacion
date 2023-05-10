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

	@Override
	public String toString() {
		return "Caseta: "+titulo+" Número: "+numero;
	}

	public int getNumero() {
		return numero;
	}
}
