package colecciones.com.colecciones.boletin1.almacen;

import java.util.ArrayList;
import java.util.List;


public class Caja {

	private int numeroCaja;
	private boolean estado;
	private List<Cliente> clientes;
	
	public Caja(int numeroCaja, boolean estado) {
		super();
		this.numeroCaja=numeroCaja;
		this.estado=estado;
		this.clientes= new ArrayList<>();
	}
	
	public int getNumeroCaja() {
		return numeroCaja;
	}

	public boolean isEstado() {
		return estado;
	}

	public int getClientes() {
		return this.clientes.size();
	}

	public void setClientes(Cliente clientes) {
		this.clientes.add(clientes);
	}

	public void abrirCaja() throws CajaException {
		if(!this.estado) {
			this.estado=true;
		} else {
			throw new CajaException("Esta caja ya está abierta");
		}
	}
	
	public void cerrarCaja() throws CajaException {
		if(this.estado && this.clientes.isEmpty()) {
			this.estado=false;
		} else {
			throw new CajaException("La caja ya está cerrada o hay un cliente en ella");
		}
	}
	public String atenderCaja() throws CajaException {
		String resultado="";
		if(this.estado) {
			resultado = "Se ha atendido al cliente con número "+ this.clientes.get(0).getNumeroCliente();
		} else {
			throw new CajaException("Error. La caja se encuentra cerrada.");
		}
		return resultado;
	}

	@Override
	public String toString() {
		return ""+numeroCaja;
	}
}