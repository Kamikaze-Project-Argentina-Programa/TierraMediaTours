package tierramedia2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tierramedia2.db.ConnectionProvider;
import tierramediatours2.LeeAtracciones;
import tierramediatours2.LeePromociones;
 
public class PromocionesDAO {

	public static List<LeePromociones> findByTipoPack(String tipo_pack) throws SQLException {
		List<LeePromociones> losLeePromociones = new ArrayList<LeePromociones>();
		
		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT ta.tipo, p.desc_prom, a.nombre, ab.nombre, ac.nombre\r\n"
				+ "FROM promociones p\r\n"
				+ "INNER JOIN tipo_atracciones ta ON p.tipo_pack = ta.id\r\n"
				+ "INNER JOIN atracciones a ON p.atraccion1 = a.id\r\n"
				+ "INNER JOIN atracciones ab ON p.atraccion2 = ab.id\r\n"
				+ "INNER JOIN atracciones ac ON p.atraccion3 = ac.id\r\n"
				+ "WHERE ta.tipo = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, tipo_pack);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			
			LeePromociones leePromociones = toLeePromociones(resultSet);
			losLeePromociones.add(leePromociones);
		}

		return losLeePromociones;
	}


	public LeePromociones findByTipo(String tipo_pack) throws SQLException {

		LeePromociones leePromociones = null;

		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT ta.tipo, p.desc_prom, a.nombre, ab.nombre, ac.nombre\r\n"
				+ "FROM promociones p\r\n"
				+ "INNER JOIN tipo_atracciones ta ON p.tipo_pack = ta.id\r\n"
				+ "INNER JOIN atracciones a ON p.atraccion1 = a.id\r\n"
				+ "INNER JOIN atracciones ab ON p.atraccion2 = ab.id\r\n"
				+ "INNER JOIN atracciones ac ON p.atraccion3 = ac.id\r\n"
				+ "WHERE ta.tipo = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, tipo_pack);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			leePromociones = toLeePromociones(resultSet);

//			System.out.println(leePromociones);

		}

		return leePromociones;
	}

	
	private static LeePromociones toLeePromociones(ResultSet resultSet) throws SQLException {
		String tipo_pack = resultSet.getString(1);
		Float desc_prom = resultSet.getFloat(2);
		String atraccion1 = resultSet.getString(3);
		String atraccion2 = resultSet.getString(4);
		String atraccion3 = resultSet.getString(5);
		return new LeePromociones(tipo_pack, desc_prom, atraccion1, atraccion2, atraccion3);
	}

}
