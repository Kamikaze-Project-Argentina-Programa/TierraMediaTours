package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import model.AttractionTypes;
import model.Promotion;
import model.User;
import persistence.AttractionTypesDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class AttractionTypesDAOImpl implements AttractionTypesDAO {

	public List<AttractionTypes> findAll() {
		try {
			String sql = "SELECT * FROM attraction_types WHERE is_active = 1";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<AttractionTypes> attractionsTypes = new LinkedList<AttractionTypes>();
			while (resultados.next()) {
				attractionsTypes.add(toAttractionTypes(resultados));
			}

			return attractionsTypes;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public AttractionTypes find(Integer id) {
		try {
			String sql = "SELECT * FROM attraction__types WHERE id = ? AND is_active = 1";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			AttractionTypes attractionTypes = null;
			if (resultados.next()) {
				attractionTypes = toAttractionTypes(resultados);
			}

			return attractionTypes;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<AttractionTypes> findOrderByType(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM attraction_types";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(AttractionTypes attractionTypes) {
		try {
			String sql = "INSERT INTO attraction_types (type, is_active) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, attractionTypes.getType());
			statement.setBoolean(i++, attractionTypes.getIsActive());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(AttractionTypes attractionTypes) {
		try {
			String sql = "UPDATE attraction_types SET type = ?, is_active = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, attractionTypes.getType());
			statement.setBoolean(i++, attractionTypes.getIsActive());
			statement.setInt(i++, attractionTypes.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(AttractionTypes attractionTypes) {
		try {
			String sql = "UPDATE attraction_types SET is_active = 0 WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, attractionTypes.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private AttractionTypes toAttractionTypes(ResultSet attractionTypesRegister) throws SQLException {
		return new AttractionTypes(attractionTypesRegister.getInt(1), attractionTypesRegister.getString(2),
				attractionTypesRegister.getBoolean(3));
	}

	@Override
	public List<AttractionTypes> findItinerary(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(AttractionTypes t, User a, Attraction b, Promotion c) {
		// TODO Auto-generated method stub
		return 0;
	}
}
