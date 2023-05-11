package com.casetas.main;

import com.casetas.ficheros.JSONManager;
import com.casetas.ficheros.XMLReader;

public class Main {

	public static void main(String[] args) {
//		Pruebas
//		System.out.println(XMLReader.cargarCasetas(".\\files\\casetasFeria.xml"));
		
		Menu m = new Menu();
		m.ejecucionMenu();
	}
}
