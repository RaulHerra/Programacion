package colecciones.com.colecciones.boletin1.diccionarioMapa;

public class Main {

	public static void main(String[] args) {
		DiccionarioMapa diccionarioJuegos = new DiccionarioMapa();
		
		//Añadimos algunas palabras
		diccionarioJuegos.anyadirPalabraSignificado("MMORPG", "Massive Multiplayer Online Rol PLaying Game");
		diccionarioJuegos.anyadirPalabraSignificado("MTG", "Magic The Gathering");
		diccionarioJuegos.anyadirPalabraSignificado("GG", "Good Game");
		diccionarioJuegos.anyadirPalabraSignificado("OMW", "On My Way");
		
		System.out.println(diccionarioJuegos.listarPalabra("MTG"));
		diccionarioJuegos.borrarPalabra("MTG");
		System.out.println(diccionarioJuegos.listarPalabra("MTG"));
		
		System.out.println(diccionarioJuegos.buscarPalabra("MMORPG"));
	}
}