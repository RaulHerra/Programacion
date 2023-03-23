package com.baraja.model;
import java.util.Objects;

public class Carta implements Comparable<Carta>{

	private int numero;
	private Palo palo;
	
	public Carta(int numero, Palo palo) throws Exception {
		super();
		if(numero<1 || numero>12 || numero==9 || numero==8) {
			throw new Exception("Valor no válido, debe introducir un valor de 1 a 7 o de 10 a 12");
		}
		this.numero = numero;
		this.palo = palo;
	}
	
	public double getValor() {
		return this.numero>9 ? 0.5 : this.numero;
	}
	
	public boolean equals(Carta otro) {
		boolean iguales=false;
		if(this.numero==otro.numero && this.palo.equals(otro.palo)) {
			iguales=true;
		}
		return iguales;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numero, palo);
	}

	@Override
	public int compareTo(Carta o) {
		return this.numero-o.numero;
	}
	
	public int getNumber() {
		return this.numero;
	}

	public String getPalo() {
		return this.palo.toString();
	}
	
	public String toString() {
		return String.format("%s de %s", this.numero, this.palo.toString().toLowerCase());
	}
}