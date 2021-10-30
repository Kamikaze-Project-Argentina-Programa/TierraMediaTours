package tierramedia2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tierramedia2.db.ConnectionProvider;
import tierramediatours2.LeeAtracciones;

public class AtraccionesDAO {
	
	

	public LeeAtracciones findById(Integer id) throws SQLException {

		LeeAtracciones leeAtracciones = null;

		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT a.id, a.nombre, a.costo, a.tiempo, a.cupo, ta.tipo\r\n" + "FROM atracciones a\r\n"
				+ "INNER JOIN tipo_atracciones ta ON ta.id = a.id_tipo WHERE a.id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			leeAtracciones = toLeeAtracciones(resultSet);

			System.out.println(leeAtracciones);
		}
		return leeAtracciones;
	}

	public static List<LeeAtracciones> findAll() throws SQLException {
		List<LeeAtracciones> losLeeAtracciones = new ArrayList<LeeAtracciones>();

		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT a.id, a.nombre, a.costo, a.tiempo, a.cupo, ta.tipo\r\n" + "FROM atracciones a\r\n"
				+ "INNER JOIN tipo_atracciones ta ON ta.id = a.id_tipo";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			LeeAtracciones leeAtracciones = toLeeAtracciones(resultSet);
			losLeeAtracciones.add(leeAtracciones);
		}
		return losLeeAtracciones;
	}

	private static LeeAtracciones toLeeAtracciones(ResultSet resultSet) throws SQLException {

		Integer id = resultSet.getInt(1);
		String nombre = resultSet.getString(2);
		Integer costo = resultSet.getInt(3);
		Float tiempo = resultSet.getFloat(4);
		Integer cupo = resultSet.getInt(5);
		String id_tipo_atraccion = resultSet.getString(6);

		return new LeeAtracciones(id, nombre, costo, tiempo, cupo, id_tipo_atraccion);
	}

	public static List<LeeAtracciones> findByTipo(String tipo) throws SQLException {
		List<LeeAtracciones> losLeeAtracciones = new ArrayList<LeeAtracciones>();

		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT a.id, a.nombre, a.costo, a.tiempo, a.cupo, ta.tipo\r\n"
				+ "FROM atracciones a INNER JOIN tipo_atracciones ta ON ta.id = a.id_tipo \r\n"
				+ "ORDER BY ta.tipo = ? DESC, a.costo DESC, a.tiempo DESC;";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, tipo);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			
			LeeAtracciones leeAtracciones = toLeeAtracciones(resultSet);
			losLeeAtracciones.add(leeAtracciones);
		}
		return losLeeAtracciones;
	}
	
	public LeeAtracciones findByNombre(String nombre) throws SQLException {

		LeeAtracciones leeAtracciones = null;

		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT a.id, a.nombre, a.costo, a.tiempo, a.cupo, ta.tipo\r\n" + "FROM atracciones a\r\n"
				+ "INNER JOIN tipo_atracciones ta ON ta.id = a.id_tipo WHERE a.id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, nombre);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			leeAtracciones = toLeeAtracciones(resultSet);

			System.out.println(leeAtracciones);
		}
		return leeAtracciones;
	}
	
	

}
