package com.mockExam.model;

public class Tweet extends Publicacion implements Valorar{

	public Tweet(String texto, Usuario usuario) {
		super(texto,usuario);
	}
	
	@Override
	protected void setTexto(String texto) {
		if(texto.length()<=50) {
			this.texto=texto;	
		}else {
			//Insertar mensaje de error
		}
	}
	public boolean valorar(String valoracion) {
		super.valorar(valoracion);
		return super.valorar(valoracion);
	}

	public String toString() {
		return String.format("Tweet.\n"+super.toString());
	}
}
