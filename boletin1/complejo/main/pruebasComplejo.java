package boletin1.complejo.main;

import boletin1.complejo.model.Complejo;

public class pruebasComplejo {
	
	
	public static void main(String[] args) {
	    Complejo c1 = new Complejo(2.5, 3.7);
	    Complejo c2 = new Complejo(1.2, 4.8);
	    
	    System.out.print("c1 = "); c1.mostrar();
	    System.out.print("c2 = "); c2.mostrar();
	    
	    Complejo suma = c1.suma(c2);
	    System.out.print("c1 + c2 = "); suma.mostrar();
	    
	    Complejo resta = c1.resta(c2);
	    System.out.print("c1 - c2 = "); resta.mostrar();
	    
	    System.out.println("c1 equals c2: " + c1.equals(c2));
	}

}
