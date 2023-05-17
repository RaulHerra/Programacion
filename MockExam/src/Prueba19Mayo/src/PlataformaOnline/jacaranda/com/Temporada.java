package Prueba19Mayo.src.PlataformaOnline.jacaranda.com;

import java.util.LinkedList;
import java.util.Objects;

public class Temporada{
	
	private String nombreTemporada;  // Nombre de las temporada
	private LinkedList<String> capitulos; // Lista donde etán los nombres de los capítulos de la temporada
	private int sumaOpiniones;  // Suma de todas las opiniones que se han realizado de la temporada
	private int numeroOpiniones; // Número de opiniones que se han realizado de la temporada
	
	/**
	 * Constructor de una temporada. Se crea sin ningún capítulo.
	 * @param nombreTemporada: recibe el nombre de la temporada.
	 * Obviamente no se ha realizado ninguna opinión sobre la temporada
	 */
	
	public Temporada(String nombreTemporada) {
		this.nombreTemporada=nombreTemporada;
		capitulos=new LinkedList<String>();
		sumaOpiniones=0;
		numeroOpiniones=0;
	}
	
	/**
	 * Método que añade un capítulo a la temporada. Se añade al final de los capítulos existente.
	 * No hay ningún control por lo que puede pasar que existan capítulos con el mismo nombre
	 * @param capitulo: nombre del capítulo a añadir
	 */
	public void annadirCapitulo(String capitulo) {
		capitulos.add(capitulo);
	}
	
	/**
	 * Elimna un capítulo de la temporada. Devuelve true si el capítulo estaba y se ha borrado, y 
	 * devuelve false si el capítulo no estába en la lista y por lo tanto no se ha podido borrar.
	 * @param capitulo: nombre del capítulo a borrar
	 * 
	 * 	 
	 * */
	
	public boolean eliminarCapitulo (String capitulo) {
		boolean borrado;
		borrado=capitulos.remove(capitulo);
		return borrado;
	}
	
	/**
	 * Métodoque valora la temporada. Los valores permitidos son de 0 a 10
	 * Se debe incrementar la suma de opiniones de la temporada y el número de valores
	 * que ha recibido la valoración
	 * @param nota
	 * @throws SerieException
	 */
	public void valorar( int nota)throws SerieException {
		if (nota < 0 || nota > 10) {
			throw new SerieException("Nota incorrecta "  + nota);
		}
		
		sumaOpiniones= sumaOpiniones + nota;
		numeroOpiniones++;
	}
	
	
	/**
	 * Debe añadir un capítulo justo detrás del capítulo que se denomina nombreCapituloAnterior.
	 * Si no encuentra el capítulo anterior saltará la excepción
	 * @param nombreCapituloAnnadir: este será el nombre del capítulo que se añadirá
	 * @param nombreCapituloAnterior: detrás de este capítulo se debe añadir

	 * @throws SerieException: si no encuentra el capítulo que indica la posición para añadir.
	 */
	public void anadirCapituloDespues(String nombreCapituloAnnadir, String nombreCapituloAnterior) throws SerieException{
		boolean encontrado = false;
		for (int i=0;i<capitulos.size();i++){
			if(capitulos.get(i).equals(nombreCapituloAnterior) 
					&& !encontrado) {
				capitulos.add(i, nombreCapituloAnnadir);
				encontrado=true;
			}
		}
		if(!encontrado) {
			throw new SerieException("No se ha encontrado el capítulo "+nombreCapituloAnterior);
		}
	}
	

	/**
	 * Devuleve el nombre del primer capítulo que contiene la palabra que  pasa por parámetro.
	 *  Si no lo encuentra salta la excepción 
	 * @param palabra
	 * @return
	 * @throws SerieException
	 */
	public String primerCapituloQueContieneEstaPalabara(String palabra) throws SerieException {
		String tituloBuscado = "";
		boolean encontrado = false;
		
		for (String titulo : capitulos){
			if(titulo.indexOf(palabra)!=-1 && !encontrado) {
				tituloBuscado=titulo;
			}
		}
		if(!encontrado) {
			throw new SerieException("No se ha encontrado un capitulo que contenga "+palabra);
		}
		return tituloBuscado;
	}
	
	
	public double getNotaMedia() {
		double notaMedia=-1;
		if (numeroOpiniones!=0) {
			notaMedia= sumaOpiniones/numeroOpiniones;
		}
		return notaMedia;
	}
	
	public int getCapitulos() {
		return this.capitulos.size();
	}
	
	public LinkedList<String> getListaCapitulos() {
		return this.capitulos;
	}
	
	public String toString() {
		return String.format("%s "
				+ "Número de capitulos %s "
				+ "Nota media %s", 
				this.nombreTemporada, capitulos.size(), getNotaMedia());
		
	}

	public String getNombreTemporada() {
		return nombreTemporada;
	}

	public int getSumaOpiniones() {
		return sumaOpiniones;
	}

	public int getNumeroOpiniones() {
		return numeroOpiniones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreTemporada);
	}

	@Override
	public boolean equals(Object obj) {
		boolean sonIguales= this==obj;
		
		if(!sonIguales && obj instanceof Temporada) {
			Temporada casteado = (Temporada) obj;
			
			sonIguales=casteado.hashCode()==this.hashCode();
		}
		return sonIguales;
	}
}