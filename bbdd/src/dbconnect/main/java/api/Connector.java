package dbconnect.main.java.api;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import dbconnect.main.java.model.Cliente;
import dbconnect.main.java.model.Pedido;

public class Connector {
	
	
	private static String USER;
	private final static String DB_USER_KEY="db.user";

	private static String PASS;
	private final static String DB_PASS_KEY="db.pass";
	
	private static String JDBC_URL;
	private final static String DB_URL_KEY="db.url";
	
	private final static String PROPERTIES_URI = "./resources/db.properties";
	
	public Connector() {
		super();
		loadProperties();
	}
	
	public void loadProperties() {
		try {
			Properties properties = new Properties();
			properties.load(new FileReader(PROPERTIES_URI));
			USER = properties.getProperty(DB_USER_KEY);
			PASS = properties.getProperty(DB_PASS_KEY);
			JDBC_URL = properties.getProperty(DB_URL_KEY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void connect() throws SQLException, ClassNotFoundException {
		
		

		Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASS); 
		Statement statement=connection.createStatement();  
		
		
		//Inserción de datos parametrizada
		/*PreparedStatement ps = connection.prepareStatement("INSERT INTO Cliente (nombre, apellido, email, fechaNacimiento, genero) "
																+ " VALUES (?, ?, ?, ?, ?)");
		ps.setString(1, "Manuel");
		ps.setString(2, "Leunam");
		ps.setString(3, "mm@gmail.com");
		ps.setString(4, "1985-11-01");
		ps.setString(5, "F");
		ps.executeUpdate();
		//ps.close();
		
		// Ejecuta query de eliminación, actualización o insercioń (DELETE, UPDATE, INSERT)
		statement.executeUpdate("INSERT INTO Cliente (nombre, apellido, email, fechaNacimiento, genero) "
								+ "VALUES ('Rigoberto', 'Ricciardiello', 'rr0@yelp.com', '1983-04-15', 'M');\n");
		
		
		
		ResultSet rs=statement.executeQuery("select * from Cliente");  
		
		while(rs.next()) {//Avanza de posición en el listado de registros y devuelve true si existe tal
			Cliente cliente = new Cliente(Integer.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), 
										rs.getString(5), rs.getString(4));
		}*/
		connection.close();  
	}
	
	public static String hacerSelectClientes(String select) {
		StringBuilder sb = new StringBuilder("");
		try {
			ResultSet rs=DriverManager.getConnection(JDBC_URL, USER, PASS).createStatement().executeQuery(select);
			
			while(rs.next()) {
				sb.append(new Cliente(Integer.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), 
						rs.getString(5), rs.getString(4))).append("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String hacerSelectPedidos(String select) {
		StringBuilder sb = new StringBuilder("");
		try {
			ResultSet rs=DriverManager.getConnection(JDBC_URL, USER, PASS).createStatement().executeQuery(select);
			
			while(rs.next()) {
				sb.append(new Pedido(Integer.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), 
						rs.getString(4))).append("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public int hacerInsertCliente(String nombre, String apellidos, String email, String fechaNacimiento, String genero) {
		int idGenerado=1;
			try {
				Connection conexion = DriverManager.getConnection(JDBC_URL, USER, PASS);
				Statement statement = conexion.createStatement();

				ResultSet rs = statement.executeQuery("select * from Cliente");
				
				while(rs.next()) {
					idGenerado++;
				}
				
				String insert = "INSERT INTO Cliente (id, nombre, apellido, email, fechaNacimiento, genero) " +
			    		"VALUES ("+idGenerado+", '"+nombre+"', '"+apellidos+"', '"+email+"', '"+fechaNacimiento+"', '"+genero+"')";
			    
			    statement.executeUpdate(insert);

			    conexion.close();
			} catch (SQLException e) {
				idGenerado = -1;
			    e.printStackTrace();
			}
		return idGenerado;
	}
	
	public int hacerInsertPedido(String status, String codigo, String id_cliente) {
		int idGenerado=1;
		boolean encontrado = false;
			try {
				Connection conexion = DriverManager.getConnection(JDBC_URL, USER, PASS);
				Statement statement = conexion.createStatement();

				ResultSet rs = statement.executeQuery("select idCliente from Pedido where idCliente="+id_cliente);
				
				if(rs.getString(1).equals(id_cliente)) {
					encontrado=true;
				}
				if(encontrado) {					
					statement.executeQuery("select * from Pedido");
					
					while(rs.next()) {
						idGenerado++;
					}
					
					String insert = "INSERT INTO Pedido (id, codigo, status, idCliente) " +
							"VALUES ("+idGenerado+", '"+codigo+"', '"+status+"', '"+id_cliente+"'";
					
					statement.executeUpdate(insert);
				}

			    conexion.close();
			} catch (SQLException e) {
				idGenerado = -1;
			    e.printStackTrace();
			}
		return idGenerado;
	}
	
	public int hacerInsertLinea(String codigo, String nombreProducto, String idPedido, String cantidad, String precio) {
		int idGenerado=1;
		boolean encontrado = false;
			try {
				Connection conexion = DriverManager.getConnection(JDBC_URL, USER, PASS);
				Statement statement = conexion.createStatement();

				ResultSet rs = statement.executeQuery("select idPedido from Linea where idCliente="+idPedido);
				
				if(rs.getString(1).equals(idPedido)) {
					encontrado=true;
				}
				if(encontrado) {					
					statement.executeQuery("select * from Linea");
					
					while(rs.next()) {
						idGenerado++;
					}
					
					String insert = "INSERT INTO Linea (id, codigo, nombreProducto, idPedido, cantidad, precio) " +
							"VALUES ("+idGenerado+", '"+codigo+"', '"+nombreProducto+"', '"+idPedido+"', '"+cantidad+"','"+precio+"'";
					
					statement.executeUpdate(insert);
				}

			    conexion.close();
			} catch (SQLException e) {
				idGenerado = -1;
			    e.printStackTrace();
			}
		return idGenerado;
	}

	public boolean hacerUpdate(String id, String nuevoDato, String columna) {
		boolean resultado = false;
		try {
			Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASS);
			Statement statement = connection.createStatement();
			String update = "";
			switch(nuevoDato.toLowerCase()){
			case "nombre":
				update = "update Cliente set nombre='"+nuevoDato+"' where id="+id;
				statement.executeUpdate(update);
				resultado = true;
				break;
			case "apellido": case "apellidos":
				update = "update Cliente set apellido='"+nuevoDato+"' where id="+id;
				statement.executeUpdate(update);
				resultado = true;
				break;
			case "email":
				update = "update Cliente set email='"+nuevoDato+"' where id="+id;
				statement.executeUpdate(update);
				resultado = true;
				break;
			case "fechaNacimiento":
				if(comprobarFechaValida(nuevoDato)) {
					update = "update Cliente set fechaNacimiento='"+nuevoDato+"' where id="+id;
					statement.executeUpdate(update);
					resultado = true;
				}else {
					System.err.println("Formato de fecha no válido");
				}
				break;
			case "genero":
				if (nuevoDato.equals("M") || nuevoDato.equals("H")) {
					update = "update Cliente set genero='"+nuevoDato+"' where id="+id;
					statement.executeUpdate(update);
					resultado = true;
				}else {
					System.err.println("Género no válido");
				}
				break;
				default:
					System.err.println("Columna no válida");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean hacerDeleteCliente(String id) {
		boolean resultado = false;
		Connection conexion;
		try {
			conexion = DriverManager.getConnection(JDBC_URL, USER, PASS);
			Statement statement = conexion.createStatement();

			ResultSet rs = statement.executeQuery("select id from Cliente where id="+id);
			
			if(rs.getString(1)!=null) {
				resultado = true;
			}
			if(resultado) {
				rs = statement.executeQuery("select id from Pedido where idCliente="+id);
				statement.executeUpdate("delete from Linea where idPedido="+rs.getString(1));
				statement.executeUpdate("delete from Pedido where idCliente="+id);
				statement.executeUpdate("delete from Cliente where id="+id);
			}else {
				System.err.println("Id no encontrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return resultado;
	}
	
	public boolean comprobarFechaValida(String fecha) {
		boolean esCorrecta = false;
		String[] fechatmp=fecha.split("-");
		
		if(fechatmp[0].length()!=4 && fechatmp[1].length()!=2 && fechatmp[2].length()!=2) {
			esCorrecta = true;
		}
		return esCorrecta;
	}
}