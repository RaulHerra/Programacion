package com.baraja.main;

import java.util.Scanner;
import com.baraja.model.Baraja;
import com.baraja.model.Carta;
import java.lang.Thread;

public class MainBaraja {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Baraja espanyola = new Baraja();
		Carta[] cartasUsuario = new Carta[10];
		Carta[] cartasBanca = new Carta[10];
		int contadorCartasUser=0, contadorCartasBanca=0;
		double valorUsuario=0, valorBanca=0;
		String anotherOne="n";
		espanyola.barajar();
		
		//Comenzamos el juego
		cartasUsuario[contadorCartasUser++]=espanyola.getSiguiente();
		valorUsuario+=cartasUsuario[contadorCartasUser-1].getValor();
		System.out.println("Tiene un "+cartasUsuario[0]+
				" Valor actual="+valorUsuario);
		do{
			do{
				System.out.println("Desea otra carta? (S/N):");
				anotherOne=sc.nextLine().toUpperCase();
			}while (!(anotherOne.equals("S")) && !(anotherOne.equals("N")));
			
			if(anotherOne.equals("S")) {
				try {
				cartasUsuario[contadorCartasUser++] = espanyola.getSiguiente();
				valorUsuario+=cartasUsuario[contadorCartasUser-1].getValor();
				System.out.println("Se ha añadido un "+cartasUsuario[contadorCartasUser-1]+
						"Valor actual="+valorUsuario);
				}catch(Exception e) {
					System.err.println("Ha llegado al número máximo de cartas");
					anotherOne="N";
				}
			}
		}while(!(anotherOne.equals("N")));
		
		//Ahora juega la banca
		do{			
			cartasBanca[contadorCartasBanca++] = espanyola.getSiguiente();
			valorBanca+=cartasBanca[contadorCartasBanca-1].getValor();
			System.out.println("La banca saca un "+cartasBanca[contadorCartasBanca-1]+
					" Valor actual de la banca="+valorBanca);
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				
			}			
		}while(valorBanca<valorUsuario && valorBanca<7.5 && valorUsuario<=7.5);
		if(valorBanca<=valorUsuario && valorBanca<=7.5) {
			System.out.println("La banca gana");
		}else {
			if (valorUsuario<7.5){
				System.out.println("Usted gana");
			}else {
				System.out.println("Nadie gana");
			}
		}
	}
}