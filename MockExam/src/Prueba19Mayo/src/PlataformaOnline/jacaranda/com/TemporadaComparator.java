package Prueba19Mayo.src.PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class TemporadaComparator implements Comparator<Temporada> {

	//Compara por capítulos
	@Override
	public int compare(Temporada o1, Temporada o2) {
		int resultado = 0;
		if (o1.getCapitulos() < o2.getCapitulos()) {
			resultado = -1;
		} else if (o1.getCapitulos() > o2.getCapitulos()) {
			resultado = 1;
		}
		return resultado;
	}
	
	//Compara por nota media
	public int comparePorNotaMedia(Temporada o1, Temporada o2) {
		int resultado = 0;
		if (o1.getNotaMedia() < o2.getNotaMedia()) {
			resultado = -1;
		} else if (o1.getNotaMedia() > o2.getNotaMedia()) {
			resultado = 1;
		}
		return resultado;
	}
}