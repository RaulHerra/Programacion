package prueba16.adn;

public class ADNUtil16 {

	final static String NUCLEOTIDOS="ATGC";
	
	public static boolean adnCorrecto(String adn) {
		
		for(int i=0;i<adn.length();i++) {
			if(NUCLEOTIDOS.indexOf(adn.substring(i,i+1))==-1) {
				return false;
			}
		}
		return true;
	}
	
	public static int contarPalabra(String cadena, String cadenaBuscar) {
		int ocurrencias=0;
		if (adnCorrecto(cadena) && adnCorrecto(cadenaBuscar) && !(cadenaBuscar.length()>cadena.length())) {
			for (int i=0;i<cadena.length();i++) {
				if (i+cadenaBuscar.length()<=cadena.length()) {
					if (cadena.substring(i,i+cadenaBuscar.length()).equals(cadenaBuscar)) {
						ocurrencias++;
					}	
				}
			}
		}
		return ocurrencias;
	}
	
	public static String descomprimeADN(String cadenaComprimida) {
		StringBuilder adnDescomprimido = new StringBuilder("");
		char letraActual='A';
		int numActual=0;
		
		for(int i=0;i<cadenaComprimida.length();i++) {
			numActual=0;
			if(Character.isAlphabetic(cadenaComprimida.charAt(i))) {
				letraActual=cadenaComprimida.charAt(i);
			}
			if(Character.isDigit(cadenaComprimida.charAt(i))) {
				numActual=Character.getNumericValue(cadenaComprimida.charAt(i));
			}
			if(numActual!=0) {
				for(int j=0;j<numActual;j++) {
					adnDescomprimido.append(letraActual);
				}	
			}
			
		}
		return adnDescomprimido.toString();
	}
	
	public static String descomprimeADN10(String cadenaComprimida) {
		StringBuilder adnDescomprimido = new StringBuilder("");
		StringBuilder numero = new StringBuilder("");
		char letraActual='A';
		int numActual=0, contador=0;
		
		for(int i=0;i<cadenaComprimida.length();i++) {
			if(Character.isAlphabetic(cadenaComprimida.charAt(i))) {
				letraActual=cadenaComprimida.charAt(i);
			}
			if(Character.isDigit(cadenaComprimida.charAt(i))) {
				contador=0;
				numero.setLength(0);
				while(contador+i<cadenaComprimida.length() && Character.isDigit(cadenaComprimida.charAt(contador+i))){
					numero.append(cadenaComprimida.charAt(contador+i));
					contador++;
				}
				numActual=Integer.valueOf(numero.toString());
			}
			if(numActual!=0) {
				for(int j=0;j<numActual;j++) {
					adnDescomprimido.append(letraActual);
				}	
				i+=numero.length()-1;
			}
			
		}
		return adnDescomprimido.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("__________Pruebas contarPalabra__________");
		System.out.println(contarPalabra("ATEHADF","ATGCTTATTAGCT"));
		System.out.println(contarPalabra("ATCGTTCTCGTTGATCTCGTTATCTCG","CGTT"));
		System.out.println(contarPalabra("ATCGTTCTCWWWGATC","CGTT"));
		System.out.println(contarPalabra("ATCGTTCTCGATC","CGWWTT"));
		
		System.out.println("__________Pruebas descomprimeADN__________");
		System.out.println(descomprimeADN("A3G2T1C3"));
		System.out.println(descomprimeADN("G6A2T3A2C1"));
		
		System.out.println("__________Pruebas descomprimeADN10__________");
		System.out.println(descomprimeADN10("A10G11"));
		System.out.println(descomprimeADN10("A23G12"));
	}
}