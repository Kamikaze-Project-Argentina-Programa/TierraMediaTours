package tierramedia2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tierramedia2.db.ConnectionProvider;
import tierramediatours2.Itinerarios;

public class ItinerariosDAO {

	public Itinerarios findByNombre(String nombre) throws SQLException {

		Itinerarios itinerarios = null;

		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT * " + "FROM itinerarios i a\r\n" + "WHERE i.id_usuario=?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, nombre);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			itinerarios = toItinerarios(resultSet);

			System.out.println(itinerarios);
		}
		return itinerarios;
	}

	private Itinerarios toItinerarios(ResultSet resultSet) throws SQLException {
		
		
		String u_nombre = resultSet.getString(1);
		String a_nombre = resultSet.getString(2);
		Float tiempo = resultSet.getFloat(3);
		Integer costo = resultSet.getInt(4);
		String promo = resultSet.getString(5);
		
		return new Itinerarios(u_nombre, a_nombre, tiempo, costo, promo);
	}

}
