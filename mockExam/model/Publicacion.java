package com.mockExam.model;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Publicacion implements Valorar, Comparable<Publicacion>{

	protected String texto;
	private LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo;
	private Usuario usuario;
	private static int codigo_siguiente=1;
	
	public Publicacion(String texto, Usuario usuario){
		this.texto=texto;
		this.usuario=usuario;
		this.fechaCreacion=LocalDateTime.now();
		this.codigo=codigo_siguiente++;
	}
	
	protected String getTexto(){
		return this.texto;
	}
	
	protected abstract void setTexto(String texto);

	@Override
	public int hashCode() {
		return Objects.hash(codigo, fechaCreacion, texto, valoracion);
	}	
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj != null && obj instanceof Publicacion) {
			Publicacion casteado = (Publicacion)obj;
			
			sonIguales = casteado.texto.equals(this.texto) &&
					casteado.fechaCreacion.equals(this.fechaCreacion) &&
					casteado.valoracion==this.valoracion &&
					casteado.codigo==this.codigo &&
					casteado.usuario.equals(this.usuario);
		}
		return sonIguales;
	}
	
	public LocalDateTime getFechaCreacion() {
		return this.fechaCreacion;
	}
	
	public int getValoracion() {
		return this.valoracion;
	}
	public boolean valorar(String valoracion) {
		boolean valorado = true;
		try{
			this.valoracion += Valoraciones.valueOf(valoracion.toUpperCase()).getValoracion();
		}catch(Exception e) {
			valorado = false;
		}
		return valorado;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public String getLoginUsuario() {
		return this.usuario.getLogin();
	}
	
	@Override
	public String toString() {
		return String.format("Publicación: %s \n"
				+ "Realizada por: %s \n"
				+ "Valoracion: %s \n"
				+ "Fecha de publicación: %s \n", this.texto, this.usuario.getLogin(), 
				this.valoracion, this.fechaCreacion.toString());
	}
	
	@Override
	public int compareTo(Publicacion otra) {
		return (this.valoracion-otra.valoracion)!=0 ? 
				this.valoracion-otra.valoracion:
				this.fechaCreacion.hashCode()-otra.fechaCreacion.hashCode();
	}
	
	public boolean isAnterior(Publicacion otra) {
		return this.fechaCreacion.isBefore(otra.fechaCreacion);
	}
	
}
