package Boletin3.fecha.model;

public class Fecha {

	private int dia, mes, anio;
	
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	public boolean esValida() {
		boolean valida = true;
		
		if (mes < 1 || mes > 12) {
			valida = false;
		}else {
			if (dia < 1 || dia > diasDeUnMes(mes, anio)) {
				valida = false;
			}
		}
	return valida;
	}
	
	public String pasarAformatoLargo(String[] meses) {
		String fechaLarga = dia + " de " + meses[mes - 1] + " de " + anio;
		return fechaLarga;
	}
	
	private int diasDeUnMes(int mes, int anio) {
		int dias = 0;
		
		switch (mes) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				dias = 31;
				break;
			case 4: case 6: case 9: case 11:
				dias = 30;
				break;
			case 2:
				dias = ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) ? 29 : 28;
		break;
	}
	
	return dias;
	}
}