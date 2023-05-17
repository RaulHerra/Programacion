package Prueba19Mayo.src.PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class SerieComparator implements Comparator<Serie> {

	//Compara por tema
	@Override
	public int compare(Serie o1, Serie o2) {
		int resultado = 0;
		if (Tema.valueOf(o1.getTema()) < Tema.valueOf(o2.getTema())) {
			resultado = -1;
		} else if (Tema.valueOf(o1.getTema()) > Tema.valueOf(o2.getTema())) {
			resultado = 1;
		}
		return resultado;
	}
}
