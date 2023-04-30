package colecciones.com.colecciones.boletin1.equiposDeportivos.ej8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import colecciones.com.colecciones.boletin1.equiposDeportivos.*;

public class EquipoEj8<T> {
	
	private static final int MAYORIA_EDAD = 18;
	private String nombreEquipo;
	Set<AlumnoEj8> alumnos;
	
	public EquipoEj8(String nombreEquipo) {
		super();
		this.nombreEquipo = nombreEquipo;
		alumnos = new HashSet<>();
	}
	
	public void annyadirAlumno(AlumnoEj8 a) throws AlumnoException {
		if(a!=null && existeAlumno(a)==null) {
			this.alumnos.add(a);
		} else {
			throw new AlumnoException("Error. El alumno ya existe.");
		}
	}
	
	public void eliminarAlumno(AlumnoEj8 a) throws AlumnoException {
		if(a!=null && existeAlumno(a)!=null) {
			this.alumnos.remove(a);
		} else {
			throw new AlumnoException("Error. El alumno no existe.");
		}
	}
	
	public AlumnoEj8 existeAlumno(AlumnoEj8 a) {
		AlumnoEj8 alumno=null;
		if(a!=null && this.alumnos.contains(a)) {
			alumno=a;
		}
		return alumno;
	}
	
	public EquipoEj8<T> unirEquipos(EquipoEj8<?> e) {
		if(e!=null && !this.alumnos.equals(e.alumnos)) {
			this.alumnos.addAll(e.alumnos);
		}
		return this;
	}
	
	public Set<AlumnoEj8> interseccionEquipo(EquipoEj8<?> e) {
		Set<AlumnoEj8> interseccion = new HashSet<>(this.alumnos);
		if(e!=null) {
			interseccion.retainAll(e.alumnos);
		}
		return interseccion;

	}

	@Override
	public String toString() {
		return "El equipo " + this.nombreEquipo + " tiene estos jugadores " + this.alumnos.toString() + ".";
	}
	
	public String listadoJugadoresMasculinos() {
		List<AlumnoEj8> tmp = new ArrayList<>();
		for(AlumnoEj8 a: this.alumnos) {
			tmp.add(a);
		}
		
		Collections.sort(tmp);
		StringBuilder sb = new StringBuilder();
		for(AlumnoEj8 a : tmp) {
			if((a.getSexo()=='H' || a.getSexo()=='a') && a.getEdad()>=MAYORIA_EDAD) {
				sb.append(a).append("\n");
			}
		}
		return sb.toString();
	}
	
	public boolean esFemenino() {
		boolean es = true;
		for(AlumnoEj8 a: this.alumnos) {
			if(a.getSexo()=='H' || a.getSexo()=='h') {
				es = false;
			}
		}
		return es;
	}
	
	public int jugadorasMayor() {
		int cont = 0;
		for(AlumnoEj8 a: this.alumnos) {
			if((a.getSexo()=='M' || a.getSexo()=='m') && a.getEdad()>=MAYORIA_EDAD) {
				cont++;
			}
		}
		return cont;
	}
	
	public int jugadoraMayor() {
		int edad = 0;
		for(AlumnoEj8 a: this.alumnos) {
			if(a.getEdad()>edad) {
				edad=a.getEdad();
			}
		}
		return edad;
	}
	
	public Set<String> jugadoresMenores() {
		Set<String> dni = new HashSet<>();
		for(AlumnoEj8 a: this.alumnos) {
			if(a.getSexo()=='H' || a.getSexo()=='h' && a.getEdad()<MAYORIA_EDAD) {
				dni.add(a.getDni());
			}
		}
		return dni;
	}
	
	public List<String> nombreAscendente(){
		List<String> nombres = new ArrayList<>();
		for(AlumnoEj8 a: this.alumnos) {
			if(a.getSexo() == 'M' || a.getSexo() == 'm') {
				nombres.add(a.getNombre());
			}
		}
		Collections.sort(nombres);
		
		return nombres;
	}
	
	public boolean hayJugadoraMayor() {
		boolean es = false;
		for(AlumnoEj8 a: this.alumnos) {
			if((a.getSexo()=='M' || a.getSexo()=='m') && a.getEdad()>=MAYORIA_EDAD) {
				es=true;
			}
		}
		return es;
	}

	public int ciudadesDistintas() {
		 Set<String> ciudades = new HashSet<>();
		 for(AlumnoEj8 a : this.alumnos) {
		    ciudades.add(a.getCiudad());
		 }
         	 return ciudades.size();
	}
}