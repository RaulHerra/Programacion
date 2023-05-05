package com.euromillon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;


public class MainEuromillon {
	
	private static final int MINIMOACIERTO=2;
	
	private static int masRepetidoDe(Historial h, String aBuscar) {
		//El string recibe "numeros" o "estrellas" y devuelve lo deseado
		int mayor=-2;
		if(aBuscar!=null && (aBuscar.toLowerCase().startsWith("estrella") 
				|| aBuscar.toLowerCase().startsWith("numero"))) {
			
			int[] listaRepetidas = 
					(aBuscar.toLowerCase().startsWith("estrella")) ? 
					new int[Combinacion.VALOR_MAXIMO_ESTRELLAS]: 
						new int[Combinacion.VALOR_MAXIMO_NUMEROS];
			
			for (LocalDate clave : h.getSorteos().keySet()) {
				Combinacion valor = h.getSorteos().get(clave);
				
				Iterator<Integer> it = 
						(aBuscar.toLowerCase().startsWith("estrella")) ? 
						 valor.getEstrellas().iterator():
							 valor.getNumeros().iterator();
				/*Según los numeros encontrados, los ponemos 
				 * en su posición correspondiente*/
				while(it.hasNext()) {
					listaRepetidas[it.next()-1]++;
				}
			}
			mayor = 0;

	        for (int i = 1; i < listaRepetidas.length; i++) {
	            if (listaRepetidas[i] > listaRepetidas[mayor]) {
	                mayor = i;
	            }
	        }
		}
		//Devolvemos +1 porque si el más repetido es el 1, devolvería 0
		return mayor+1;
	}
	
	private static int menosRepetidoDe(Historial h, String aBuscar) {
		//El string recibe "numeros" o "estrellas" y devuelve lo deseado
		int menor=-2;
		if(aBuscar!=null && (aBuscar.toLowerCase().startsWith("estrella") 
				|| aBuscar.toLowerCase().startsWith("numero"))) {
			
			int[] listaRepetidas = 
					(aBuscar.toLowerCase().startsWith("estrella")) ? 
					new int[Combinacion.VALOR_MAXIMO_ESTRELLAS]: 
						new int[Combinacion.VALOR_MAXIMO_NUMEROS];
			
			for (LocalDate clave : h.getSorteos().keySet()) {
				Combinacion valor = h.getSorteos().get(clave);
				
				Iterator<Integer> it = 
						(aBuscar.toLowerCase().startsWith("estrella")) ? 
						 valor.getEstrellas().iterator():
							 valor.getNumeros().iterator();
				/*Según los numeros encontrados, los ponemos 
				 * en su posición correspondiente*/
				while(it.hasNext()) {
					listaRepetidas[it.next()-1]++;
				}
			}
			menor = 0;

	        for (int i = 1; i < listaRepetidas.length; i++) {
	            if (listaRepetidas[i] < listaRepetidas[menor]) {
	                menor = i;
	            }
	        }
		}
		//Devolvemos +1 porque si el más repetido es el 1, devolvería 0
		return menor+1;
	}
	
	private static int aciertosEnHistorico(Historial h, Combinacion c) {
		int contador=0;
		for (LocalDate clave : h.getSorteos().keySet()) {
			if(c.comprobarCombinacion(h.getSorteos().get(clave))>MINIMOACIERTO) {
				contador++;
			}
		}
		return contador;
	}
	
	private static List<Integer> numerosConsecutivos(Historial h) {
		Combinacion mayorCombinacion = null;
		int mayorSecuencia=0;
		for (LocalDate clave : h.getSorteos().keySet()) {
			int contador = 0;
			Combinacion valor = h.getSorteos().get(clave);
			Object[] tmp = (Object[]) valor.getNumeros().toArray();
			for(byte i=1; i<tmp.length;i++) {
				if((int)tmp[i]==(int)tmp[i-1]+1) {
					contador++;
				}
			}
			if(contador>mayorSecuencia) {
				mayorSecuencia=contador;
				mayorCombinacion=h.getSorteos().get(clave);
			}
		}
		return mayorCombinacion.getNumeros();
	}
	
	public static void main(String[] args) {
		File euromillon = new File("C:\\Users\\raulh\\Desktop\\1ºDAW\\"
				+ "Jose Manuel\\Programación\\Ficheros\\Euromillones - "
				+ "2004 a 2022.csv");
		Historial h = new Historial();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader
					(euromillon));
			String tmp = br.readLine();
			String[] linea = tmp.split(",");
			String[] fechaLinea = linea[0].split("/");
			while(tmp!=null){
				tmp = br.readLine();
				if(tmp!=null) {
					linea = tmp.split(",");
					fechaLinea = linea[0].split("/");
				
					try {
						h.addSorteo(Integer.valueOf(fechaLinea[2]),
								Integer.valueOf(fechaLinea[1]),
								Integer.valueOf(fechaLinea[0]), 
								new Combinacion(Integer.valueOf(linea[1]),
										Integer.valueOf(linea[2]),
										Integer.valueOf(linea[3]),
										Integer.valueOf(linea[4]),
										Integer.valueOf(linea[5]),
										Integer.valueOf(linea[7]),
										Integer.valueOf(linea[8])));
					} catch (NumberFormatException | HistorialException | 
							CombinacionException e) {
						e.printStackTrace();
					}
				}  
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(masRepetidoDe(h,"estrella"));
		System.out.println(masRepetidoDe(h,"numeros"));
		System.out.println(masRepetidoDe(h,"canelita"));
		
		System.out.println(menosRepetidoDe(h,"estrella"));
		System.out.println(menosRepetidoDe(h,"numeros"));
		System.out.println(menosRepetidoDe(h,"canelita"));
		
		try {
			System.out.println(aciertosEnHistorico(h, 
					new Combinacion(18,19,20,40,41,3,2)));
		} catch (CombinacionException e) {
			e.printStackTrace();
		}
		
		System.out.println(numerosConsecutivos(h));
	}
}