package com.mockExam.model;

public class Recomendacion extends Publicacion {

	private int numeroEstrellas;

	public Recomendacion(String texto, Usuario usuario, int estrellas) {
		super(texto, usuario);
		this.numeroEstrellas=estrellas;
		}

	@Override
	protected void setTexto(String texto) {
		if(texto.length()>=100 && texto.length()<=200) {
			this.texto=texto;	
		}else {
			//Insertar mensaje de error
		}
	}
	
	@Override
	public String toString() {
		return String.format("Recomendación.\n"+super.toString()+"Número de estrellas: %s", this.getEstrellas());
	}

	public int getEstrellas() {
		return this.numeroEstrellas;
	}
	
	
	
}
