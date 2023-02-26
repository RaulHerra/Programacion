package boletin1.geometria.model;

public class Rectangulo {

	private double longitud;
	private double ancho;
	
	public Rectangulo() {
		super();
		this.longitud = 1;
		this.ancho = 1;
	}
	
	public Rectangulo(double longitud, double ancho) {
		super();
		this.longitud = longitud;
		this.ancho = ancho;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = (longitud<0 || longitud>20) ? longitud : this.longitud;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = (ancho<0 || ancho>20) ? ancho : this.ancho;
	}
	
	public double calcularArea() {
		return this.longitud*this.ancho;
	}
	
	public double calcularPerimetro() {
		return (this.longitud*2)+(this.ancho*2);
	}
}

