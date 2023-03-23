package com.baraja.model;
import java.util.Arrays;
import java.util.Random;

public class Baraja {

	private Carta[] cartas;
	final static int mAX_SIZE=40;
	int siguiente;
	
	public Baraja() {
		this.cartas = Baraja.crearBarajaEspanyola();
		System.out.println("");
		this.siguiente=0;
	}

	//He unido el generarPalo y el generalNumero en crearBarajaEspanyola
	private static Carta[] crearBarajaEspanyola() {
		Carta[] cartas = new Carta[mAX_SIZE];
		int posicion=0;
		for (Palo p : Palo.values()) {
			for(short j=0;j<12;j++) {
				if((j+1)!=8 && (j+1)!=9) {
					try {
						cartas[posicion++] = new Carta(j+1,p);
					} catch (Exception e) {
					}
				}
			}
		}
		return cartas;
	}
	
	public void barajar() {
		Random rn = new Random();
		Carta aux;
		for(short i=0;i<mAX_SIZE-1;i++) {
			int randomNum = rn.nextInt((mAX_SIZE - 0) + 1) + 0;
			aux=cartas[i];
			cartas[i]=cartas[randomNum%mAX_SIZE];
			cartas[randomNum%mAX_SIZE]=aux;
		}
	}
	
	public Carta getSiguiente() {
		return this.cartas[siguiente++];
	}
	
	public void nuevoJuego() {
		this.siguiente=0;
	}
	
	@Override
	public String toString() {
		return (Arrays.toString(this.cartas));
	}
	
}
