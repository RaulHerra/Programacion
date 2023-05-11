package com.casetas.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.casetas.ficheros.JSONManager;
import com.casetas.model.Calle;
import com.casetas.model.Caseta;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	
	private Map<Calle, List<Caseta>> sacarFamiliares(Map<Calle, List<Caseta>> original){
		Map<Calle, List<Caseta>> resultado = new HashMap<>();
		
		for(Calle c : original.keySet()) {
			List<Caseta> tmp = new ArrayList<>();
			for(Caseta cas : original.get(c)) {
				if(cas.getClase().equals("FAMILIAR")) {
					tmp.add(cas);
				}
			}
			resultado.put(c, tmp);				
		}
		
		return resultado;
	}
	
	public void ejecucionMenu() {
		String menu="1.Mostrar todas las casetas existentes de una calle.\n"
				+ "2.Mostrar todas las casetas de tipo familar.\n"
				+ "3.Mostrar todas las casetas de tipo distrito.\n"
				+ "4.Mostrar todas las casetas que no sean ni familiares ni distritos."
				+ "5.Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen.\n"
				+ "6.Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo distrito que existen.\n"
				+ "7.Eliminar una caseta\n"
				+ "8.Salir\n";
		int opcion = 0;
		System.out.println(sacarFamiliares(JSONManager.cargarDatosComoMapa(".\\files\\casetasOrdenadas.json")));
		/*do {
			System.out.println(menu);
			opcion=Integer.parseInt(sc.nextLine());
			
			switch(opcion) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				System.out.println("Gracias por usar nuestro programa");
				break;
			default:
				System.err.println("Opcion Incorrecta");
			}
		}while(opcion!=0);*/
		System.out.println("No crashea");
	}
}
