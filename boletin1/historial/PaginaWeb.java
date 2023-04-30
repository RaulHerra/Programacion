package colecciones.com.colecciones.boletin1.historial;

import java.time.LocalDateTime;
import java.util.Objects;

import colecciones.com.colecciones.boletin1.equiposDeportivos.Alumno;

public class PaginaWeb {

	private String nombre;
	private String url;
	private LocalDateTime fechaVisitada;
	
	public PaginaWeb(String nombre, String url) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.fechaVisitada = LocalDateTime.now();
	}
	
	public LocalDateTime getFechaVisitada() {
		return fechaVisitada;
	}

	//Se considera que en tanto en el hashCode y en el equals con comparar la URL es suficiente
	@Override
	public int hashCode() {
		return Objects.hash(url);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj != null && obj instanceof PaginaWeb) {
			PaginaWeb casteado = (PaginaWeb)obj;
			
			sonIguales = casteado.url.equals(this.url);
		}
		return sonIguales;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s", this.nombre, this.url);
	}
	
	
}