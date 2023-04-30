package colecciones.com.colecciones.boletin1.diccionario;

import java.util.HashSet;
import java.util.Set;

public class Descripcion {
	private String palabra;
	private Set<String> significados;
	
	public Descripcion(String clave, String significado) {
		super();
		this.significados = new HashSet<>();
		this.palabra = clave;
		this.significados.add(significado);
	}

	public String getPalabra() {
		return palabra;
	}

	public void setSignificado(String significado) {
		this.significados.add(significado);
	}

	@Override
	public String toString() {
		return this.significados.toString();
	}
}