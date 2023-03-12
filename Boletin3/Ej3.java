package Boletin3;
import java.lang.Exception;
import java.util.Scanner;

public class Ej3 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
	int[] digitCount = new int[10];
	int count = 0, sum = 0, maxCount = 0, maxDigit = 0, num=-1;
	boolean continueInput = true;
	
	while (continueInput) {
		System.out.print("Introduce un número entre 1 y 1000 (0 para terminar): ");
		try{
			num = Integer.valueOf(sc.nextLine());
		}catch (Exception e) {
			System.out.println("Debe ser un dato numérico");
		}
		if (num == 0) {
			continueInput = false;
		}else{
			if (num >= 1 && num <= 1000) {
				count++;
				sum += num;
				digitCount[num % 10]++;
			}
		}
	}
	
	double media = sum / count;
	System.out.println("La media de los números leídos es: " + media);
	
	for (int i = 0; i < 10; i++) {
		if (digitCount[i] == 0) {
			System.out.println("No ha terminado ningún número en el dígito " + i);
		}else{
			System.out.println("Hay "+ digitCount[i] +" número/s que terminan en "+ i);
		}
		if (digitCount[i] > maxCount) {
			maxCount = digitCount[i];
			maxDigit = i;
		}
	}
	
	System.out.println("El dígito en el que más números terminan es: "+ maxDigit);
	}
}