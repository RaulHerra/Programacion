package Boletin3;
import java.util.Arrays;
import java.util.Scanner;

public class Ej2 {

	static Scanner sc = new Scanner(System.in);
	
	public static int[] desplazarVectorIzquierda(int[] numeros) {
		int aux=0;
		
		for(int i=0;i<numeros.length-1;i++) {
			aux=numeros[i+1];
			numeros[i+1]=numeros[i];
			numeros[i]=aux;
		}
		return numeros;
	}
	public static int[] desplazarVectorDerecha(int[] numeros) {
		int aux=0;
		
		for(int i=0;i<numeros.length-1;i++) {
			aux=numeros[((i+1)*-1)+numeros.length-1];
			numeros[((i+1)*-1)+numeros.length-1]=numeros[(i*-1)+numeros.length-1];
			numeros[(i*-1)+numeros.length-1]=aux;
		}
		return numeros;
	}
	
	public static void main(String[] args) {
		/*int[] numeros = new int[10];
		
		for(int i=0;i<numeros.length;i++) {
			System.out.println("Introduzca el "+(i+1)+"º numero");
			numeros[i]=Integer.valueOf(sc.nextLine());
		}*/
		int[] numeros = {1,2,3,4,5,6,7,8,9,10};

		System.out.println(Arrays.toString(desplazarVectorIzquierda(numeros)));
		System.out.println(Arrays.toString(desplazarVectorDerecha(numeros)));
		System.out.println(Arrays.toString(desplazarVectorDerecha(numeros)));
	}
}
