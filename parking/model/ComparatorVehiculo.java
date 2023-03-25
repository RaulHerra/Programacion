package com.parking.model;

import java.util.Comparator;

public class ComparatorVehiculo implements Comparator<Vehiculo> {

	@Override
	public int compare(Vehiculo v1, Vehiculo v2) {
		return v1.compareTo(v2);
	}
	
	public static int compararPorMarcaYModelo(Vehiculo v1, Vehiculo v2) {
		return (v1.getMarca().compareTo(v2.getMarca()))==0 ? 
				(v1.getMarca().compareTo(v2.getMarca())):
				(v1.getModelo().compareTo(v2.getModelo()));
	}

	public static int compararPorTipoYCombustible(Vehiculo v1, Vehiculo v2) {
		return (v1.getTipoVehiculo().compareTo(v2.getTipoVehiculo()))==0 ? 
				(v1.getTipoVehiculo().compareTo(v2.getTipoVehiculo())):
				(v1.getCombustible().compareTo(v2.getCombustible()));
	}
	
	public static int compararPorMatricula(Vehiculo v1, Vehiculo v2) {
		return v1.getMatricula().compareTo(v2.getMatricula());
	}
}
