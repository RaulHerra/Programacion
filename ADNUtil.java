package ejercicios;

public class ADNUtil {

	final static String LETRASADN="ATGC";
	
	public static boolean adnEsCorrecto(String adn) {
		
		for(int i=0;i<adn.length();i++) {
			if(LETRASADN.indexOf(adn.substring(i,i+1))==-1) {
				return false;
			}
		}
		return true;
	}
	
	public static int obtenerNumeroPalabras(String adn) {
		//se comprueba que la cadena sea correcta
		if (adnEsCorrecto(adn)){
			int palabras=1; /*Inicializa en 1 porque se entiende que si entra en la funcion,
			minimo un palabra contiene*/
			
			for(int i=0;i<adn.length();i++) {
				//se valora si aparecen ATT o TAA (Sin salirnos de rango)
				if(i+3<=adn.length()) {
					if (adn.substring(i,i+3).equals("ATT") || adn.subSequence(i,i+3).equals("TAA")) {
						palabras++;
					}	
				}
			}
			return palabras;
		}else {
			return -1;
		}
	}
	
	public static StringBuilder descomprimeADN(String comprimida) {
		StringBuilder adn = new StringBuilder("");
		StringBuilder error = new StringBuilder("ERROR");
		
		/*Salta de 2 en 2 para recoger siempre el valor númerico en el for j*/
			for(int i=1;i<comprimida.length();i+=2) {
				for(byte j=0;j<Integer.parseInt(comprimida.substring(i,i+1));j++){
					adn.append(comprimida.substring(i-1,i));
				}
			}
		if(!(adnEsCorrecto(adn.toString()))) {
			return error;
		}
		return adn;	
	}
	
	/*public static StringBuilder descomprimeADN10(String comprimida) {
		StringBuilder adn = new StringBuilder("");
		StringBuilder error = new StringBuilder("ERROR");
		
		

		if(!(adnEsCorrecto(adn.toString()))) {
			return error;
		}
		return adn;	
	}
	TODO */
	
	/*public static StringBuilder comprimeADN(String descomprimida) {
		StringBuilder adn = new StringBuilder("");
		StringBuilder error = new StringBuilder("ERROR");
		//Se valora que el dato de entrada es correcto
		if(!(adnEsCorrecto(descomprimida.toString()))) {
			return error;
		}
		
		for(int i=0;i<descomprimida.length();i++) {
			int contador=0;
			for(int j=0;j<descomprimida.length();j++) {
				if (j+1<descomprimida.length()) {
					if (descomprimida.substring(j,j+1).equals(descomprimida.substring(j+1,j+2))) {
						contador++;
					}else {
						break;
					}
				}
			}
			if (adn.substring(i).indexOf(descomprimida.substring(i,i+1))==-1) {
				adn.append(descomprimida.substring(i,i+1)+contador);
		}
	}
		return adn;
	}
	
	No me ha dado tiempo a terminar este método, sin embargo creo haber estado medianamente cerca
	*/
	
	public static void main(String[] args) {
		System.out.println(obtenerNumeroPalabras("AAATGCAGCAATTAA")+" palabras");
		System.out.println(obtenerNumeroPalabras("AAATGCAGCAATTAAW")+" palabras");
		System.out.println(descomprimeADN("A3T1G1C1A1G1C1A2T2A2"));
		System.out.println(descomprimeADN("A3T1G1C1A1G1C1A2T2W2"));
		/*System.out.println(comprimeADN("AAATGCAGCAATTAA"));
		System.out.println(comprimeADN("AAATGCAGCAATTAAW"));*/
	}
}
