package com.mapas;

import java.util.ArrayList;
import java.util.Collection;

public class MainMapeando {

	public static void main(String[] args) {
		//Prueba personas
		Persona canelita = new Persona("Jonatan", "Vera", Genero.MASCULINO);
		Persona eminem = new Persona("Marshall", "B. Mathers III", Genero.MASCULINO);
		Persona britney = new Persona("Britney", "J. Spears", Genero.FEMENINO);
		Persona shakira = new Persona("Shakira Isabel", "Mebarak Ripoll", Genero.FEMENINO);
		Persona lovato = new Persona("Demi", "Lovato", Genero.NEUTRO);
		Persona kordhell = new Persona("Kordhell", "???", Genero.DESCONOCIDO);
		
		Collection<Persona> personas = new ArrayList<>();
		Mapeando mapaMain1 = new Mapeando();
		
		personas.add(canelita);
		personas.add(eminem);
		personas.add(britney);
		personas.add(shakira);
		personas.add(lovato);
		personas.add(kordhell);
		
		System.out.println(mapaMain1.mapearPersonasPorGenero(personas));
		
		//Prueba numericos
		Mapeando mapaMain2 = new Mapeando();
		System.out.println(mapaMain2.contarNumeros(Mapeando.generarNumerosAleatorios(20)));
	}
}
