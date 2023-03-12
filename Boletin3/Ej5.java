package Boletin3;
import java.util.Random;
import java.util.Scanner;

public class Ej5 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		// Número de cartas a repartir
		System.out.print("¿Cuántas cartas se van a repartir? ");
		int numCartas =0;
		do {
			try {
				numCartas = Integer.valueOf(sc.nextLine());
			}catch(Exception e) {
				System.out.println("Debe ser un valor numérico");
			}
		}while(numCartas!=0 && numCartas<0);
		
		String[] palos = {"oros", "copas", "espadas", "bastos"};
		int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		
		String[] jugador1 = new String[numCartas];
		String[] jugador2 = new String[numCartas];
		
		// Inicializar vector de cartas disponibles
		String[] cartasDisponibles = new String[48];
		int idx = 0;
		for (int i = 0; i < palos.length; i++) {
			for (int j = 0; j < numeros.length; j++) {
				cartasDisponibles[idx] = numeros[j] + " de " + palos[i];
				idx++;
			}
		}
	
		// Repartir cartas
		Random random = new Random();
		for (int i = 0; i < numCartas; i++) {
			int idxCartaJugador1 = random.nextInt(cartasDisponibles.length);
			jugador1[i] = cartasDisponibles[idxCartaJugador1];
			cartasDisponibles = eliminarCarta(cartasDisponibles, idxCartaJugador1);
		
			int idxCartaJugador2 = random.nextInt(cartasDisponibles.length);
			jugador2[i] = cartasDisponibles[idxCartaJugador2];
			cartasDisponibles = eliminarCarta(cartasDisponibles, idxCartaJugador2);
		}
	
		// Imprimir cartas repartidas
		System.out.println("Cartas del jugador 1:");
		for (String carta : jugador1) {
			System.out.print(carta + ", ");
		}
	
		System.out.println("\nCartas del jugador 2:");
		for (String carta : jugador2) {
			System.out.print(carta + ", ");
		}
	}

	private static String[] eliminarCarta(String[] cartas, int indice) {
		String[] nuevasCartas = new String[cartas.length - 1];
		int j = 0;
		for (int i = 0; i < cartas.length; i++) {
			if (i != indice) {
				nuevasCartas[j] = cartas[i];
				j++;
			}
		}
		return nuevasCartas;
	}

}