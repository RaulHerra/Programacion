package com.casetas.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.casetas.ficheros.JSONManager;
import com.casetas.ficheros.XMLReader;
import com.casetas.model.Calle;
import com.casetas.model.Caseta;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	private Map<Calle, List<Caseta>> sacarFamiliares(Map<Calle, Caseta[]> original){
		Map<Calle, List<Caseta>> resultado = new HashMap<>();
		
		for(Calle c : original.keySet()) {
			List<Caseta> tmp = new ArrayList<>();
			for(int i = 0; i<original.size();i++) {
				if(original.get(c)[i]!=null && original.get(c)[i].getClase().equals("FAMILIAR")) {
					tmp.add(original.get(c)[i]);
				}
			}
			if(tmp.size()!=0) {
				resultado.put(c, tmp);
			}
		}
		return resultado;
	}
	
	private Map<Calle, List<Caseta>> sacarDistritos(Map<Calle, Caseta[]> original){
		Map<Calle, List<Caseta>> resultado = new HashMap<>();
		
		for(Calle c : original.keySet()) {
			List<Caseta> tmp = new ArrayList<>();
			for(int i = 0; i<original.size();i++) {
				if(original.get(c)[i]!=null && original.get(c)[i].getClase().equals("DISTRITO")) {
					tmp.add(original.get(c)[i]);
				}
			}
			if(tmp.size()!=0) {
				resultado.put(c, tmp);
			}
		}
		return resultado;
	}
	
	private Map<Calle, List<Caseta>> sacarOtros(Map<Calle, Caseta[]> original){
		Map<Calle, List<Caseta>> resultado = new HashMap<>();
		
		for(Calle c : original.keySet()) {
			List<Caseta> tmp = new ArrayList<>();
			for(int i = 0; i<original.size();i++) {
				if(original.get(c)[i]!=null && !original.get(c)[i].getClase().equals("DISTRITO") && !original.get(c)[i].getClase().equals("FAMILIAR")) {
					tmp.add(original.get(c)[i]);
				}
			}
			if(tmp.size()!=0) {
				resultado.put(c, tmp);
			}
		}
		return resultado;
	}
	
	private Map<Calle, List<Caseta>> extraerCalleDeArray(Map<Calle, Caseta[]> original, Calle calle) throws MenuException{
		//Convertimos Caseta[] a List<Caseta>
		Map<Calle, List<Caseta>> resultado = new HashMap<>();
		
		for(Calle c : original.keySet()) {
			if(c.equals(calle)) {
				resultado.put(calle, Arrays.asList(original.get(c)));
			}
		}
		
		if(resultado.size()!=0) {
			return resultado;
		}else {
			throw (new MenuException("La calle insertada no existe"));
		}
	}
	
	private String quitarCalles(Map<Calle, List<Caseta>> original) {
		StringBuilder resultado = new StringBuilder("");
		for(Calle c : original.keySet()) {
			resultado.append(original.get(c).toString());
		}
		return resultado.toString();
	}
	
	private void eliminarCaseta(Map<Calle, Caseta[]> original, String caseta) throws MenuException {
		boolean borrado = false;
		//Convertimos Caseta[] a List<Caseta>
		Map<Calle, List<Caseta>> resultado = new HashMap<>();
		
		for(Calle c : original.keySet()) {
			if(!resultado.containsKey(c)) {
				resultado.put(c, Arrays.asList(original.get(c)));
			}
		}
		for(Calle c : original.keySet()) {
			for(Caseta cas : original.get(c)) {
				if(cas.getTitulo().equals(caseta)) {
					resultado.get(c).remove(cas);
					borrado=true;
				}
			}
		}
		if(!borrado) {
			throw new MenuException("La caseta a borrar no existe");
		}
	}
	
	
	public void ejecucionMenu() {
		String menu="1.Mostrar todas las casetas existentes de una calle.\n"
				+ "2.Mostrar todas las casetas de tipo familar.\n"
				+ "3.Mostrar todas las casetas de tipo distrito.\n"
				+ "4.Mostrar todas las casetas que no sean ni familiares ni distritos.\n"
				+ "5.Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen.\n"
				+ "6.Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo distrito que existen.\n"
				+ "7.Eliminar una caseta\n"
				+ "8.Salir";
		int opcion = 0;
		JSONManager.toJSON(XMLReader.cargarCasetas(".\\files\\casetasFeria.xml"),".\\files\\casetasOrdenadas.json");
		Map<Calle, Caseta[]> datos=JSONManager.cargarDatos(".\\files\\casetasOrdenadas.json");
		
		do {
			System.out.print(menu+"\nOpcion: ");
			opcion=Integer.parseInt(sc.nextLine());
			
			switch(opcion) {
			case 1:
				try {
					System.out.print("Introduzca el nombre de la calle: ");
					System.out.println(extraerCalleDeArray(datos, new Calle(sc.nextLine().toUpperCase()))); 
				} catch (MenuException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println(quitarCalles(sacarFamiliares(datos)));
				break;
			case 3:
				System.out.println(quitarCalles(sacarDistritos(datos)));
				break;
			case 4:
				System.out.println(quitarCalles(sacarOtros(datos)));
				break;
			case 5:
				System.out.println(sacarFamiliares(datos));
				break;
			case 6:
				System.out.println(sacarDistritos(datos));
				break;
			case 7:
				System.out.print("Introduzca el titulo de la caseta a borrar: ");
				String cadenita = sc.nextLine();
				try {
					eliminarCaseta(datos, cadenita);
				} catch (MenuException e) {
					e.printStackTrace();
				}
				break;
			case 8:
				System.out.println("Gracias por usar nuestro programa");
				break;
			default:
				System.err.println("Opcion Incorrecta");
			}
		}while(opcion!=8);
	}
}
