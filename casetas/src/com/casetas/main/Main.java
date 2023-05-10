package com.casetas.main;

import com.casetas.ficheros.JSONManager;
import com.casetas.ficheros.XMLReader;

public class Main {

	public static void main(String[] args) {
		System.out.println(XMLReader.cargarCasetas(".\\files\\casetasFeria.xml"));
//		JSONManager.toJSON(XMLReader.cargarCasetas(".\\files\\casetasFeria.xml"),".\\files\\casetasOrdenadas.json");
		System.out.println(JSONManager.cargarDatos(".\\files\\casetasFeria.xml"));
		
		Menu m = new Menu();
		m.ejecucionMenu();
	}
}
