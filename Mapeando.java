package com.mapas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Mapeando {
	
	/**
	 * Recibe una colección de personas y las agrupa por género
	 * @param personas
	 * @return Mapa con la colección de personas clasificadas por género
	 */
	public Map<Genero, Collection<Persona>> mapearPersonasPorGenero(Collection<Persona> personas) {
		Map<Genero, Collection<Persona>> personasPorGenero = new HashMap<>();
		
		for(Genero g : Genero.values()) {
			/* se debe crear una nueva instancia de tmp en cada iteraci�n del 
			 * bucle externo en lugar de borrar el contenido del mismo objeto. */
			Collection<Persona> tmp = new ArrayList<>();
			for(Persona p : personas) {
				if(p.getGenero().equals(g)){
					tmp.add(p);
				}
			}
			personasPorGenero.put(g, tmp);
		}
		return personasPorGenero;
	}
	
	
	/**
	 * Recibe una colección de números y cuenta cuantas ocurrencias hay de cada uno de ellos
	 * creando un mapa en el que aparece cada número junto a su frecuencia de aparición
	 * @param numeros
	 * @return Tabla de frecuencias de los números facilitados
	 */
	public Map<Integer, Integer> contarNumeros(Collection<Integer> numeros){
		Map<Integer, Integer> numericos = new HashMap<>();
		int contador=0;
		for (Integer i=0;i<=numeros.size();i++) {
			contador=0;
			for(Integer n : numeros) {
				if(n.equals(i)) {
					contador++;
				}
			}
			numericos.put(i, contador);
		}
		return numericos;
	}
	
	
	/**
	 * Genera una lista de números aleatorios entre 0 y 20 del tamaño indicado
	 * @param size tamaño de la lista
	 * @return lista de size números aleatorios
	 */
	public static Collection<Integer> generarNumerosAleatorios(int size){
		List<Integer> numeros = new ArrayList<>() {{
			for(int i=0; i<size; i++) {
				//Se pone hasta 21 para que pueda aparecer el numero 20
				add(new Random().nextInt(21));
			}
		}};
		
		return numeros;
	}
}
