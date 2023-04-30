package colecciones.com.colecciones.boletin1.reverse;

import java.util.Arrays;

public class MainReverse {

	public static void main(String[] args) {
		Integer[] arrayNumeros = new Integer[10];
		
		//Para crear un array que contenga del 0 al 9
		for (byte i=0;i<arrayNumeros.length;i++) {
			arrayNumeros[i]=Integer.valueOf(i);
		}
		
		String[] alumnos = {"Ana", "Bautisto", "Cecilio", "David", "Ernesto", "Fernando", "Gabriel", "Hermenegildo", "Ignacio", "Javier", "Kalista", "Leopolda", "Maria", "Noelia", "Ñu"};
		
		System.out.println(Arrays.toString(arrayNumeros));
		System.out.println(Arrays.toString(Reverse.reverse(arrayNumeros)));
		System.out.println(Arrays.toString(alumnos));
		System.out.println(Arrays.toString(Reverse.reverse(alumnos)));
	}
}
