package com.mockExam.model;

public class Post extends Publicacion implements Valorar{

	private int numeroLecturas=0;
	private String tema;
	
	public Post(String texto, Usuario usuario, String tema) {
		super(texto, usuario);
		this.tema=tema;
	}

	@Override
	protected void setTexto(String texto) {
		if(!texto.isBlank()) {
			this.texto=texto;	
		}else {
			//Insertar mensaje de error
		}
	}
	public String getTema() {
		return tema;
	}

	public boolean valorar(String valoracion) {
		boolean valorado=false;
		/*Si un usuario introduce mal la valoracion, no recapitulará la lectura del mismo
		 * ya que podría introducirse mal el dato todas las veces que se quisiera sin aumentar
		 * las valoraciones, pero llevando el numeroLecturas hasta las nubes (Sería un dato
		 * irreal)
		 */
		try {
			super.valorar(valoracion);
			this.numeroLecturas++;
			valorado=true;
		}catch (Exception e) {
			//Añadir mensaje de error
		}
		return valorado;
	}
	
	@Override
	public String toString() {
		return String.format("Post.\n"+super.toString());
	}

}
