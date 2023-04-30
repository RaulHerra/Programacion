package colecciones.com.colecciones.boletin1.almacen;

import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Almacen a = new Almacen();
		try {
			a.abrirCaja(1);
			a.abrirCaja(2);
			a.abrirCaja(3);
		} catch (CajaException e) {
			e.printStackTrace();
		}
		
		//Abrimos una caja que ya está abierta
		try {
			a.abrirCaja(1);
		} catch (CajaException e) {
			e.printStackTrace();
		}
		
		
		try {
			a.cerrarCaja(2);
		} catch (CajaException e) {
			e.printStackTrace();
		}
		
		//Cerramos una caja ya cerrada
		try {
			a.cerrarCaja(2);
		} catch (CajaException e) {
			e.printStackTrace();
		}
		
		//Añadimos varios clientes
		a.nuevoCliente();
		a.nuevoCliente();
		a.nuevoCliente();
		a.nuevoCliente();
		//atendemos a los clientes de la caja 1
			try {
				a.atenderCliente(1);
			} catch (CajaException e) {
				e.printStackTrace();
			}
		
		//Intentamos cerrar una caja con clientes
		try {
			a.cerrarCaja(3);
		} catch (CajaException e) {
			e.printStackTrace();
		}
	}
}