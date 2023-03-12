package Boletin3;
import java.util.Scanner;

public class Ej6 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Introduce una frase: ");
		String frase = sc.nextLine().toLowerCase(), letras = "abcdefghijklmnopqrstuvwxyz";
		int[] contadores = new int[26]; // Array de contadores para cada letra del alfabeto
		
		// Recorrer la frase y aumentar los contadores correspondientes
		for (int i = 0; i < frase.length(); i++) {
			char letra = frase.charAt(i);
			if (Character.isLetter(letra)) {
				int indice = letras.indexOf(letra);
				contadores[indice]++;
			}
		}
		
		// Mostrar los contadores para cada letra que aparece en la frase
		for (int i = 0; i < contadores.length; i++) {
			if (contadores[i] > 0) {
				System.out.println(letras.charAt(i) + ": " + contadores[i]);
			}
		}
	}
}