package colecciones.com.colecciones.boletin1.equiposDeportivos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Equipo {

	private String nombre;
	private Set<Alumno> alumnos;
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		alumnos=new HashSet<>();
	}
	
	public Equipo(String nombre, Set<Alumno> alumnos) {
		this(nombre);
		this.alumnos = alumnos;
	}

	public void anyadirAlumno(Alumno a) throws AlumnoException {
		if(!alumnos.contains(a)) {
			alumnos.add(a);
		}else
			throw new AlumnoException("Ya existe ese alumno");
	}
	
	public void borrarAlumno(Alumno a) throws AlumnoException {
//		if(alumnos.contains(a)) {
//			alumnos.remove(a);
//		}else
//			throw new AlumnoException("El alumno no existe");
		boolean borrado = false;
		Iterator<Alumno> it = this.alumnos.iterator();
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
	
	public Alumno devolverAlumno(Alumno aBuscar) {
		return (alumnos.contains(aBuscar)) ? aBuscar : null;
	}
	
	public String mostrarAlumnos() {
		return alumnos.toString();
	}
	
	public String unionDeEquipos(Equipo otro) {
		StringBuilder sb = new StringBuilder();
		Set<Alumno> aux = new HashSet<>();
		//Al meter los dos en un mismo conjunto se evitan los datos repetidos
		aux.addAll(this.alumnos); aux.addAll(otro.alumnos);
		
		for(Alumno a : aux) {
			sb.append(a+" ");
		}
		
		return sb.toString();
	}

	public String interseccionDeEquipos(Equipo otro) {
		StringBuilder sb = new StringBuilder();
		
		for(Alumno a : this.alumnos) {
			for(Alumno e : otro.alumnos) {
				if(a.equals(e)) {
					sb.append(a+" ");
				}
			}
		}
		return sb.toString();
	}

	public String toString() {
		return String.format("Equipo %s con la plantilla %s", this.nombre, this.alumnos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumnos, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = false;
		if(obj != null && obj instanceof Alumno) {
			Alumno casteado = (Alumno)obj;
			sonIguales = this.hashCode()==casteado.hashCode();
		}
		return sonIguales;
	}
	
}
