package com.parking.model;
import java.time.LocalDate;

public class Vehiculo implements Comparable<Vehiculo> {

	private String marca;
	private String modelo;
	private String matricula;
	private Combustible combustible;
	private LocalDate entrada;
	private TipoVehiculo tipoVehiculo;
	
	public Vehiculo(String marca, String modelo, String matricula, String combustible,
			String tipoVehiculo) throws VehiculoException{
		super();
		this.marca = marca;
		this.modelo = modelo;
		
		if(matricula.length()<=8 && getNumerosMatricula(matricula)==4) {
			this.matricula = matricula;
		}else {
			throw new VehiculoException("Matrícula "+matricula+" no válida");
		}
		
		try{
			this.combustible = Combustible.valueOf(combustible.toUpperCase());
		}catch(Exception e) {
			throw new VehiculoException("Combustible no valido");
		}
		
		//Entiendo que se creará el vehículo en el momento en el que entre al parking
		this.entrada = LocalDate.now();
		
		try{
			this.tipoVehiculo = TipoVehiculo.valueOf(tipoVehiculo.toUpperCase());
		}catch(Exception e) {
			throw new VehiculoException("TipoVehiculo no valido");
		}
	}
	
	//Método para contar que las matrículas tengan 4 numeros
	private static int getNumerosMatricula(String matricula) {
		int resultado=0;
		for(byte i=0;i<matricula.length();i++) {
			if(Character.isDigit(matricula.charAt(i))) {
				resultado++;
			}
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return String.format("Vehiculo tipo %s, con combustible %s, matricula %s, modelo"
				+ " %s de la marca %s", this.tipoVehiculo.toString().toLowerCase(),
				this.combustible.toString().toLowerCase(), this.matricula, this.modelo, 
				this.marca);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj != null && obj instanceof Vehiculo) {
			Vehiculo casteado = (Vehiculo)obj;
			
			sonIguales = casteado.marca.equals(this.marca) && 
					casteado.modelo.equals(this.modelo) && 
					casteado.matricula.equals(this.matricula) && 
					casteado.combustible.equals(this.combustible) &&
					casteado.entrada.equals(this.entrada) &&
					casteado.tipoVehiculo.equals(this.tipoVehiculo);
		}
		return sonIguales;
	}

	@Override
	public int compareTo(Vehiculo o) {
		return this.entrada.compareTo(o.entrada);
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	protected String getMatricula() {
		return matricula;
	}

	public Combustible getCombustible() {
		return combustible;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	
}