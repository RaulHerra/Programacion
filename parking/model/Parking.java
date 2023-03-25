package com.parking.model;

public class Parking implements Comparable<Vehiculo>{

	private Vehiculo[] vehiculos;
	private static final int CAPACIDAD=50;
	
	public Parking() {
		this.vehiculos = new Vehiculo[CAPACIDAD];
	}
	
	public boolean entradaVehiculo(Vehiculo v) {
		boolean estaEnLista = false;
		int huecoLibre=-1;
		
		for(byte i=0;i<CAPACIDAD;i++) {
			//Comprobamos que el coche no esté en la lista comprobando la matrícula
			if(this.vehiculos[i] != null && 
					ComparatorVehiculo.compararPorMatricula(this.vehiculos[i],v)==0) {
				estaEnLista=true;
				break;
			}
			//Se recoge la información sobre el primer hueco libre encontrado
			if(this.vehiculos[i]==null && huecoLibre==-1) {
				huecoLibre=i;
			}
		}
		if(!estaEnLista) {
			this.vehiculos[huecoLibre]=v;
		}
		//Queremos que devuelva true si el vehiculo no está en la lista
		return !estaEnLista;
	}

	public boolean salidaVehiculo(Vehiculo v) {
		boolean sale = false;
		//Comprueba que el vehiculo esté en la lista
			for(byte i=0;i<CAPACIDAD;i++) {
				//Comprobamos que el coche no esté en la lista comprobando la matrícula
				if(this.vehiculos[i] != null && this.vehiculos[i].equals(v)) {
					this.vehiculos[i]=null;
					sale=true;
				}
			}
		return sale;
	}
	
	@Override
	public int compareTo(Vehiculo o) {
		return this.compareTo(o);
	}

	public Vehiculo[] getVehiculos() {
		return vehiculos;
	}
}