package colecciones.com.colecciones.boletin1.almacen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Almacen {
	private static final int NUM_MAX_CAJAS = 20;
	private List<Caja> cajas;
	
	public Almacen() {
		super();
		this.cajas=new ArrayList<>();
		
		for(int i=0; i<=NUM_MAX_CAJAS; i++) {
			this.cajas.add(new Caja(i, false));
		}
	}
	
	public void abrirCaja(int numero) throws CajaException {
		for(Caja c: this.cajas) {
			if (c.getNumeroCaja()==numero) {
				c.abrirCaja();
			}
		}
	}
	
	public void cerrarCaja(int numero) throws CajaException {
		for(Caja c: this.cajas) {
			if (c.getNumeroCaja()==numero) {
				c.cerrarCaja();
			}
		}
	}
	
	public void nuevoCliente() {
		Cliente c = new Cliente();
		Collections.sort(this.cajas, new CajaComparator());
		this.cajas.get(0).setClientes(c);
	}
	
	public String atenderCliente(int num) throws CajaException {
		String resultado="";
		for(Caja c: this.cajas) {
			if (c.getNumeroCaja()==num) {
				resultado = c.atenderCaja();
			}
		}
		return resultado;
	}
}