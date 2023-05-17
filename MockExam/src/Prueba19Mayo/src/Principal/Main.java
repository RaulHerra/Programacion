package Prueba19Mayo.src.Principal;

import java.io.File;

import Prueba19Mayo.src.PlataformaOnline.jacaranda.com.SerieException;
import Prueba19Mayo.src.PlataformaOnline.jacaranda.com.Series;
import Prueba19Mayo.src.PlataformaOnline.jacaranda.com.Tema;

public class Main {

	
	
	public static void main(String[] args) {
		
		Series series = new Series();
		try {
			series.annadirSerie("This is us", 2015, Tema.DRAMA);
			series.annadirSerie("Friends", 1990, Tema.COMEDIA);
			series.annadirSerie("Dallas", 1970, Tema.INTRIGA);
			series.annadirTemporada("This is us", "Empezamos");
			series.annadirTemporada("This is us", "Seguimos");
			series.annadirTemporada("This is us", "Finalizamos");
			series.annadirCapituloTemporada("This is us", "Empezamos", "La familia");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El problema");
			series.annadirCapituloTemporada("This is us", "Empezamos", "Los niños");
			series.annadirCapituloTemporada("This is us", "Empezamos", "CAsi el final");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El final");
		} catch (SerieException e) {
			e.printStackTrace();
		}
		for(String s : series.getMapSeries().keySet()) {
			File carpeta = new File(".\\files\\"+s);
			carpeta.mkdir();
			String rutaSerie = ".\\files\\"+s+"\\Serie.csv";
			String rutaTemporada = ".\\files\\"+s+"\\Temporada.csv";
			String rutaCapitulos = ".\\files\\"+s+"\\Capitulos.csv";
			CrearCSV.crearArchivoCSV(rutaSerie, series.getMapSeries().get(s), "Serie");
			CrearCSV.crearArchivoCSV(rutaTemporada, series.getMapSeries().get(s), "Temporada");
			CrearCSV.crearArchivoCSV(rutaCapitulos, series.getMapSeries().get(s), "Capitulos");
		}
	}
}