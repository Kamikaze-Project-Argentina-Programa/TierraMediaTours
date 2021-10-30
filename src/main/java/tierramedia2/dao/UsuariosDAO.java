package tierramedia2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tierramedia2.db.ConnectionProvider;
import tierramediatours2.LeeUsuarios;

public class UsuariosDAO {

	public LeeUsuarios findById(Integer id) throws SQLException {

		LeeUsuarios leeUsuarios = null;

		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT u.id, u.nombre, u.saldo, u.tiempo_dispo, a.tipo FROM usuarios "
				+ "u LEFT OUTER JOIN tipo_atracciones a ON u.id_tipo_atraccion = a.id WHERE u.id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			leeUsuarios = toLeeUsuarios(resultSet);

			System.out.println(leeUsuarios);

		}

		return leeUsuarios;
	}

	public List<LeeUsuarios> findAll() throws SQLException {

		List<LeeUsuarios> losLeeUsuarios = new ArrayList<LeeUsuarios>();

		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT u.id, u.nombre, u.saldo, u.tiempo_dispo, a.tipo FROM usuarios u LEFT OUTER JOIN tipo_atracciones a ON u.id_tipo_atraccion = a.id";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			LeeUsuarios leeUsuarios = toLeeUsuarios(resultSet);
			losLeeUsuarios.add(leeUsuarios);
		}

		return losLeeUsuarios;

	}

	public LeeUsuarios findByNombre(String nombre) throws SQLException {

		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT u.nombre, u.saldo, u.tiempo_dispo AS tiempo, a.tipo FROM usuarios u LEFT OUTER JOIN tipo_atracciones a ON u.id_tipo_atraccion = a.id WHERE u.nombre=?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, nombre);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			System.out.println("Nombre: " + resultSet.getString(1));
			System.out.println("Saldo: " + resultSet.getInt(2));
			System.out.println("Tiempo disponible: " + resultSet.getFloat(3));
			System.out.println("Tipo favorito: " + resultSet.getString(4));
		}

		return null;

	}
	
	

	public LeeUsuarios toLeeUsuarios(ResultSet resultSet) throws SQLException {
		Integer id = resultSet.getInt(1);
		String nombre = resultSet.getString(2);
		Integer saldo = resultSet.getInt(3);
		Float tiempo = resultSet.getFloat(4);
		String tipo = resultSet.getString(5);

		return new LeeUsuarios(id, nombre, saldo, tiempo, tipo);
	}
}
