package tierramediatours2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import tierramedia2.db.ConnectionProvider;

public class Itinerarios {

	private String id_usuario;
	private String id_atracciones;
	private Float tiempo_total;
	private Integer costo_total;
	private String id_promo;

	public Itinerarios() {
		
	};
	
	public Itinerarios(String id_usuario, String id_atracciones, Float tiempo_total, Integer costo_total,
			String id_promo) {

		this.id_usuario = id_usuario;
		this.id_atracciones = id_atracciones;
		this.tiempo_total = tiempo_total;
		this.costo_total = costo_total;
		this.id_promo = id_promo;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getId_atracciones() {
		return id_atracciones;
	}

	public void setId_atracciones(String id_atracciones) {
		this.id_atracciones = id_atracciones;
	}

	public Float getTiempo_total() {
		return tiempo_total;
	}

	public void setTiempo_total(Float tiempo_total) {
		this.tiempo_total = tiempo_total;
	}

	public Integer getCosto_total() {
		return costo_total;
	}

	public void setCosto_total(Integer costo_total) {
		this.costo_total = costo_total;
	}

	public String getId_promo() {
		return id_promo;
	}

	public void setId_promo(String id_promo) {
		this.id_promo = id_promo;
	}

	@Override
	public String toString() {
		return "Nombre: " + id_usuario + ", Atracciones: " + id_atracciones + ", Tiempo Total: "
				+ tiempo_total + ", Costo Total: " + costo_total + ", Promo Seleccionada: " + id_promo;
	}

	public int insert(LeeUsuarios leeUsuarios, LeeAtracciones leeAtracciones) throws SQLException {

		Connection connection = ConnectionProvider.getConnection();

		String query = "INSERT INTO itinerario (id_usuario, id_atracciones, tiempo_total, costo_total, id_promo) VALUES (?,?,?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1, leeUsuarios.getNombre());
		preparedStatement.setString(2, leeAtracciones.getNombre());
		preparedStatement.setFloat(3, leeAtracciones.getTiempo());
		preparedStatement.setInt(4, leeAtracciones.getCosto());
		preparedStatement.setString(5, "N");
		int rowsUpdated = preparedStatement.executeUpdate();
		if (rowsUpdated == 1) {
			System.out.println("~");
		}
		return rowsUpdated;

	}
	
	public int insertPromos(LeeUsuarios leeUsuarios, LeeAtracciones leeAtracciones) throws SQLException {

		Connection connection = ConnectionProvider.getConnection();

		String query = "INSERT INTO itinerario (id_usuario, id_atracciones, tiempo_total, costo_total, id_promo) VALUES (?,?,?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1, leeUsuarios.getNombre());
		preparedStatement.setString(2, leeAtracciones.getNombre());
		preparedStatement.setFloat(3, leeAtracciones.getTiempo());
		preparedStatement.setInt(4, leeAtracciones.getCosto());
		preparedStatement.setString(5, leeAtracciones.getId_tipo_atraccion());
		int rowsUpdated = preparedStatement.executeUpdate();
		if (rowsUpdated == 1) {
			System.out.println("La promocion " + leeAtracciones.getId_tipo_atraccion() + " fue guardada exitosamente!");
		}
		return rowsUpdated;

	}

}
