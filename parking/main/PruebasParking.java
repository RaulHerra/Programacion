package com.parking.main;

import com.parking.model.*;

public class PruebasParking {

	public static void main(String[] args) {
		
		Parking p = new Parking();
		Vehiculo vehiculoEspectacular = null, cochazo = null, coshe = null;
		
		try {
			vehiculoEspectacular = new Vehiculo("Ford","Fusion","1234 PNG","Gasoil","Automovil");
		} catch (VehiculoException e) {
			e.printStackTrace();
		}
		
		//Vehiculo con matricula ya existente
		try {
			cochazo = new Vehiculo("Citroen","c4","1234 PNG","Gasoil","Automovil");
		} catch (VehiculoException e) {
			e.printStackTrace();
		}
		
		//Vehiculo igual al anterior pero sin matricula repetida
		try {
			coshe = new Vehiculo("Citroen","c4","4321 JPG","Gasoil","Automovil");
		} catch (VehiculoException e) {
			e.printStackTrace();
		}
		
		//Comprobacion de que los tres coches han sido creados con exito
		System.out.println(vehiculoEspectacular);
		System.out.println(cochazo);
		System.out.println(coshe);
		
		//Pruebas de insercion de vehiculos en el parking
		/*Si devuelve true es que entra al parking,
		 * si devuelve false es que no entra al parking*/
		System.out.println(p.entradaVehiculo(vehiculoEspectacular));
		System.out.println(p.entradaVehiculo(cochazo));
		System.out.println(p.entradaVehiculo(coshe));
		

		System.out.println("");
		//Pruebas de salida de vehiculos en el parking
		/*Si devuelve true es que sale del parking,
		 * si devuelve false es que no sale del parking*/
		System.out.println(p.salidaVehiculo(vehiculoEspectacular));
		System.out.println(p.salidaVehiculo(cochazo));
		System.out.println(p.salidaVehiculo(coshe));
	}
}
