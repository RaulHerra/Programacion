package Boletin3;
import java.util.Scanner;

public class Ej1 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] numeros = new int[10];
		
		for(int i=0;i<numeros.length;i++) {
			System.out.println("Introduzca el "+(i+1)+"º numero");
			numeros[i]=Integer.valueOf(sc.nextLine());
		}
		
		for(int i=numeros.length-1;i>=0;i--) {
			if(i!=0) {
				System.out.print(numeros[i]+", ");	
			}else {
				System.out.print(numeros[i]);
			}	
		}
	}
}