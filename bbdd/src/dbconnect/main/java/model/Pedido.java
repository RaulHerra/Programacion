package dbconnect.main.java.model;

public class Pedido {

	private int id;
	private String codigo;
	private String status;
	private String idCliente;
	
	public Pedido(int id, String codigo, String status, String idCliente) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.status = status;
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return String.format("id: %s, codigo: %s, status: %s, idCliente: %s",
				this.id, this.codigo, this.status, this.idCliente);
	}
	
	
	
}
