package boletin1.banco.model;

public class Cuenta {

	private double saldo;
	private int ingresos;
	private int reintegros;
	
	public Cuenta() {}
	
	public Cuenta(double saldo) {
		super();
		this.saldo = saldo;
		this.ingresos = 0;
		this.reintegros = 0;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getIngresos() {
		return ingresos;
	}

	public int getReintegros() {
		return reintegros;
	}
	
	public void ingresar(double cantidad) {
		this.saldo+=cantidad;
		this.ingresos++;
	}
	
	public void retirar(double cantidad) {
		if(this.saldo-cantidad>=0) {
			this.saldo-=cantidad;
			this.reintegros++;
		}
	}
}
