package tierramediatours2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tierramedia2.db.ConnectionProvider;

public class LeeUsuarios {
	private Integer id;
	private String nombre;
	private Integer saldo;
	private Float tiempo_dispo;
	private String id_tipo_atraccion;
	public static ArrayList<LeeAtracciones> listaDeAtracAceptadas = new ArrayList<LeeAtracciones>();
	public static ArrayList<LeePromociones> listaDePromosPromociones = new ArrayList<LeePromociones>();

	public LeeUsuarios(Integer id, String nombre, Integer saldo, Float tiempo_dispo, String id_tipo_atraccion) {
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
		this.tiempo_dispo = tiempo_dispo;
		this.id_tipo_atraccion = id_tipo_atraccion;

	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "LeeUsuarios [id=" + id + ", nombre=" + nombre + ", saldo=" + saldo + ", tiempo_dispo=" + tiempo_dispo
				+ ", id_tipo_atraccion=" + id_tipo_atraccion + "]\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public Float getTiempo_dispo() {
		return tiempo_dispo;
	}

	public void setTiempo_dispo(Float tiempo_dispo) {
		this.tiempo_dispo = tiempo_dispo;
	}

	public String getId_tipo_atraccion() {
		return id_tipo_atraccion;
	}

	public void setId_tipo_atraccion(String id_tipo_atraccion) {
		this.id_tipo_atraccion = id_tipo_atraccion;
	}

	public static void darBienvenida(LeeUsuarios leeUsuarios) {
		System.out.println("¡Bienvenid@ " + leeUsuarios.getNombre() + "!");
		System.out.println("Veo que te gustan las atracciones de " + leeUsuarios.id_tipo_atraccion + "...");
		System.out.println("Dispones de " + leeUsuarios.getSaldo() + " monedas.");	
	}

	// Resta tiempo cuando hace una atraccion:
	public int gastarTiempo(LeeAtracciones leeAtracciones) throws SQLException {
		float tiempoUsado = leeAtracciones.getTiempo();
		this.tiempo_dispo -= tiempoUsado;
		
		Connection connection = ConnectionProvider.getConnection();

		String query = "UPDATE usuarios\r\n"
				+ "SET tiempo_dispo = tiempo_dispo - ?\r\n"
				+ "WHERE nombre = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setFloat(1, leeAtracciones.getTiempo());
		preparedStatement.setString(2, this.getNombre());
		int rowsUpdated = preparedStatement.executeUpdate();
		
		return rowsUpdated; 
	}

	// Restar monedas cuando hace una atreccion:
	public int gastarMonedas(LeeAtracciones leeAtracciones) throws SQLException {
		
		int monedasUsadas = leeAtracciones.getCosto();
		this.saldo -= monedasUsadas;
		
		Connection connection = ConnectionProvider.getConnection();

		String query = "UPDATE usuarios\r\n"
				+ "SET saldo = saldo - ?\r\n"
				+ "WHERE nombre = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, leeAtracciones.getCosto());
		preparedStatement.setString(2, this.getNombre());
		int rowsUpdated = preparedStatement.executeUpdate();
		
		return rowsUpdated; 
		
	}

	public static ArrayList<LeeAtracciones> getListaDeAtracAceptadas() {
		return listaDeAtracAceptadas;
	}
}
