package colecciones.com.colecciones.boletin1.diccionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Diccionario {

	private Set<Descripcion> entrada;

	public Diccionario() {
		super();
		this.entrada = new HashSet<>();
	}
	
	public void anyadirPalabraSignificado(String palabra,String significado) {
		boolean palabraEnDiccionario = false;
		Descripcion d = null;
		Iterator<Descripcion> it = this.entrada.iterator();
		if(palabra!=null && significado!=null) {
			while(it.hasNext() && !palabraEnDiccionario) {
				d=it.next();
				if(d.getPalabra().equals(palabra)) {
					palabraEnDiccionario=true;
				}
			}
			if(palabraEnDiccionario) {
				d.setSignificado(significado);
			} else {
				this.entrada.add(new Descripcion(palabra,significado));
			}
		}
	}
	
	public String buscarPalabra(String palabra) {
		boolean estaPalabra = false;
		Descripcion d = new Descripcion("","");
		Iterator<Descripcion> it = this.entrada.iterator();
		if(palabra!=null) {
			while(it.hasNext() && !estaPalabra) {
				d=it.next();
				if(d.getPalabra().equals(palabra)) {
					estaPalabra=true;
				}
			}	
		}
		return d.toString();
	}
	
	public void borrarPalabra(String palabra) {
		boolean estaPalabra = false;
		Iterator<Descripcion> it = this.entrada.iterator();
		if(palabra!=null) {
			while(it.hasNext() && !estaPalabra) {
				if(it.next().getPalabra().equals(palabra)) {
					estaPalabra=true;
					it.remove();
				}
			}	
		}
	}
	
	public List<String> listarPalabra(String cadena) {
		List<String> palabras = new ArrayList<>();
		Iterator<Descripcion> it = this.entrada.iterator();
		Descripcion d = null;
		if(cadena!=null) {
			while(it.hasNext()) {
				d=it.next();
				if(d.getPalabra().startsWith(cadena)) {
					palabras.add(d.getPalabra());
				}
			}	
		}
		Collections.sort(palabras);
		return palabras;
	}
}