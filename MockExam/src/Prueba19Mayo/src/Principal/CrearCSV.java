package Prueba19Mayo.src.Principal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Prueba19Mayo.src.PlataformaOnline.jacaranda.com.Serie;
import Prueba19Mayo.src.PlataformaOnline.jacaranda.com.Temporada;

public class CrearCSV {

	public static void crearArchivoCSV(String nombreDeArchivo, Serie s, String tipo) {
		File archivo = new File(nombreDeArchivo);
		try {
			archivo.createNewFile();
		} catch (IOException e) {}
		if(tipo.equals("Serie")) {
			crearArchivoCSVSerie(nombreDeArchivo, ",", s);
		}else {
			if(tipo.equals("Temporada")) {
				crearArchivoCSVTemporada(nombreDeArchivo, ",", s);
			}else {
				if(tipo.equals("Capitulos")) {
					crearArchivoCSVCapitulos(nombreDeArchivo, ",", s);
				}else {
					System.err.println("Opción incorrecta");
				}
			}
		}
	}

	private static void crearArchivoCSVCapitulos(String file, String delim, Serie serie) {
		final String NEXT_LINE = "\n";
		try {
			FileWriter fw = new FileWriter(file);
			
			for(Temporada t : serie.getTemporadas()) {
				int contador = 0;
				fw.append(serie.getNombreSerie());
				fw.append(t.getNombreTemporada());
				if(t.getCapitulos()!=0) {
					fw.append(t.getListaCapitulos().get(contador));
				}
				fw.append(NEXT_LINE);
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			/*Error al crear el archivo, por ejemplo, el archivo 
			 está actualmente abierto.*/
			e.printStackTrace();
		}
	}
	private static void crearArchivoCSVSerie(String file, String delim, Serie serie) {
		final String NEXT_LINE = "\n";
		try {
			FileWriter fw = new FileWriter(file);
			
			fw.append(serie.getNombreSerie());
			fw.append(String.valueOf(serie.getAnno()));
			fw.append(serie.getTema().toString());
			
			fw.flush();
			fw.close();
		} catch (IOException e) {
			/*Error al crear el archivo, por ejemplo, el archivo 
			 está actualmente abierto.*/
			e.printStackTrace();
		}
	}
	private static void crearArchivoCSVTemporada(String file, String delim, Serie serie) {
		final String NEXT_LINE = "\n";
		try {
			FileWriter fw = new FileWriter(file);
			
			for(Temporada t : serie.getTemporadas()) {
				fw.append(serie.getNombreSerie());
				fw.append(t.getNombreTemporada());
				fw.append(String.valueOf(t.getCapitulos()));
				fw.append(String.valueOf(t.getSumaOpiniones()));
				fw.append(String.valueOf(t.getNumeroOpiniones()));
				fw.append(NEXT_LINE);
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			/*Error al crear el archivo, por ejemplo, el archivo 
			 está actualmente abierto.*/
			e.printStackTrace();
		}
	}
}