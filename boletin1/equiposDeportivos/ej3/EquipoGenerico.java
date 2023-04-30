package colecciones.com.colecciones.boletin1.equiposDeportivos.ej3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import colecciones.com.colecciones.boletin1.equiposDeportivos.*;

public class EquipoGenerico<T> {

	private String nombre;
	private Set<T> elementos;
	
	public EquipoGenerico(String nombre) {
		super();
		this.nombre = nombre;
		elementos=new HashSet<>();
	}
	
	public EquipoGenerico(String nombre, Set<T> elementos) {
		this(nombre);
		this.elementos = elementos;
	}

	public void anyadirElemento(T a) throws AlumnoException {
		if(!elementos.contains(a)) {
			elementos.add(a);
		}else
			throw new AlumnoException("Ya existe ese alumno");
	}
	
	public void borrarElemento(T a) throws AlumnoException {
		boolean borrado = false;
		Iterator<T> it = this.elementos.iterator();
		while(it.hasNext() && !borrado) {
			if(it.next().equals(a)) {
				it.remove();
				borrado=true;
			}
			if(!borrado) {
				throw new AlumnoException("El alumno no existe");
			}
		}
	}
	
	public T devolverAlumno(T aBuscar) {
		return (elementos.contains(aBuscar)) ? (T)aBuscar : null;
	}
	
	public String mostrarelementos() {
		return elementos.toString();
	}
	
	public String unionDeEquipos(EquipoGenerico<T> otro) {
		StringBuilder sb = new StringBuilder();
		Set<T> aux = new HashSet<>();
		//Al meter los dos en un mismo conjunto se evitan los datos repetidos
		aux.addAll(this.elementos); aux.addAll(otro.elementos);
		
		for(T a : aux) {
			sb.append(a+" ");
		}
		
		return sb.toString();
	}

	public String interseccionDeEquipos(EquipoGenerico<T> otro) {
		StringBuilder sb = new StringBuilder();
		
		for(T a : this.elementos) {
			for(T e : otro.elementos) {
				if(a.equals(e)) {
					sb.append(a+" ");
				}
			}
		}
		return sb.toString();
	}

	public String toString() {
		return String.format("Equipo %s con la plantilla %s", this.nombre, this.elementos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(elementos, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = false;
		if(obj != null && obj instanceof EquipoGenerico) {
			T casteado = (T)obj;
			sonIguales = this.hashCode()==casteado.hashCode();
		}
		return sonIguales;
	}
	
}
