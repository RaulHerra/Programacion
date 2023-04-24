package mockExam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Historial {

	private Map<LocalDate,Combinacion> sorteos;
	
	public Historial() {
		super();
		sorteos=new HashMap<>();
	}
	
	public boolean addSorteo(LocalDate fecha,Combinacion combinacion) throws HistorialException {
		if(!sorteos.containsKey(fecha) && (fecha.getDayOfWeek().getValue()==2 
				|| fecha.getDayOfWeek().getValue()==5)) {
			sorteos.put(fecha, combinacion);
		}else{
			throw new HistorialException("Esa fecha ya está almacenada o no es martes/viernes");
		}
		return true;
	}

	public boolean addSorteo(int anyo, int mes, int diaMes, Combinacion combinacion) throws HistorialException {
		return addSorteo(LocalDate.of(anyo, mes, diaMes),combinacion);
	}
	
	public boolean actualizarSorteo(int anyo, int mes, int diaMes, Combinacion combinacion) throws HistorialException {
		return actualizarSorteo(LocalDate.of(anyo, mes, diaMes),combinacion);
	}
	
	public boolean actualizarSorteo(LocalDate fecha, Combinacion combinacion) throws HistorialException {
		boolean actualizado=true;
		if(!(sorteos.isEmpty())) {
			actualizado=false;
			throw new HistorialException("Los sorteos están vacios, no hay nada a actualizar");
		}else {
			sorteos.put(fecha, combinacion);
		}
		return actualizado;
	}
	
	public boolean borrarSorteo() throws HistorialException {
		boolean seHaBorrado=true;
		if(sorteos!=null && !sorteos.isEmpty()) {
			sorteos.clear();
		}else {
			seHaBorrado=false;
			throw new HistorialException("Ya se encuentra vacio");
		}
		return seHaBorrado;
	}
	
	public List<String> listarSorteosDesdeFecha(LocalDate fecha){
		List<String> lista = new ArrayList<>();
		if(sorteos!=null && !sorteos.isEmpty()) {
			for(LocalDate clave : sorteos.keySet()) {
				if(clave.isAfter(fecha)) {
					lista.add(sorteos.get(clave).toString());
				}
			}
		}
		return lista;
	}
	
	public List<String> mostrarHistorico(){
		List<String> lista = new ArrayList<>();
		if(sorteos!=null && !sorteos.isEmpty()) {
			for(LocalDate clave : sorteos.keySet()) {
				lista.add(sorteos.get(clave).toString());
			}
		}
		return lista;
	}
	
	public Combinacion comprobarAciertos(LocalDate fecha) throws HistorialException{
		Combinacion acierto;
		if(sorteos!=null && sorteos.containsKey(fecha)) {
			acierto=sorteos.get(fecha);
		}else {
			acierto=null;
			throw new HistorialException("No está almacenada la fecha "+fecha.toString());
		}
		return acierto;
	}
}