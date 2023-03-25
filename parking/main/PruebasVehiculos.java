package com.parking.main;
import com.parking.model.*;

public class PruebasVehiculos {

	public static void main(String[] args) {
		Vehiculo coche = null, cochazo = null, coshe = null, vehiculoEspectacular = null;
		
		//Objeto bien creado
		try {
			coche = new Vehiculo("Honda","civic","1234 PNG","Gasoil","Automovil");
		} catch (VehiculoException e) {
			e.printStackTrace();
		}
		
		//Combustible no valido
		try {
			cochazo = new Vehiculo("Citroen","c4","1234 PNG","Diesel","Automovil");
		} catch (VehiculoException e) {
			e.printStackTrace();
		}
		
		//TipoVehiculo no valido
		try {
			coshe = new Vehiculo("Ford","Fusion","1234 PNG","Gasoil","coshe");
		} catch (VehiculoException e) {
			e.printStackTrace();
		}
		
		/*Objeto con matrícula ya existente por otro vehiculo (No da error, daría error al
		meterlos juntos a un mismo parking)*/
		try {
			vehiculoEspectacular = new Vehiculo("Ford","Fusion","1234 PNG","Gasoil","Automovil");
		} catch (VehiculoException e) {
			e.printStackTrace();
		}
		
		System.out.println(coche);
		System.out.println(cochazo);
		System.out.println(coshe);
		System.out.println(vehiculoEspectacular);
		
		System.out.println("");
		
	}

}