package colecciones.com.colecciones.boletin1.reverse;


public class Reverse {

	protected static <T> T[] reverse (T[] arrayOriginal) {
		T[] aux = (T[]) new Object[arrayOriginal.length];
		for(int i=0;i<arrayOriginal.length;i++) {
			aux[i]=arrayOriginal[arrayOriginal.length-i-1];
		}
		return aux;
	}
}
