package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import model.Itinerary;
import model.Promotion;
import model.User;
import persistence.ItineraryDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ItineraryDAOImpl implements ItineraryDAO {

	public List<Itinerary> findAll() {
		try {
			String sql = "SELECT i.id, i.username, u.username, i.attraction, a.name, i.cost, i.duration, i.promotion FROM itinerary i\r\n"
					+ "INNER JOIN users u ON u.id = i.username\r\n"
					+ "INNER JOIN attractions a ON a.id = i.attraction";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Itinerary> itineraries = new LinkedList<Itinerary>();
			while (resultados.next()) {
				itineraries.add(toItinerary(resultados));
			}

			return itineraries;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Itinerary find(Integer id) {
		try {
			String sql = "SELECT i.id, i.username, u.username, i.attraction, a.name, i.cost, i.duration, i.promotion FROM itinerary i\r\n"
					+ "INNER JOIN users u ON u.id = i.username\r\n"
					+ "INNER JOIN attractions a ON a.id = i.attraction WHERE i.username = ? ";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Itinerary itinerary = null;
			if (resultados.next()) {
				itinerary = toItinerary(resultados);
			}

			return itinerary;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public List<Itinerary> findOrderByType(Integer id) {
		try {
			String sql = "SELECT * FROM attractions WHERE is_active = 1 ORDER BY type = ? DESC";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			statement.setInt(1, id);

			List<Itinerary> itineraries = new LinkedList<Itinerary>();
			while (resultados.next()) {
				itineraries.add(toItinerary(resultados));
			}

			return itineraries;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Itinerary toItinerary(ResultSet itineraryRegister) throws SQLException {
		return new Itinerary(itineraryRegister.getInt(1), itineraryRegister.getInt(2), itineraryRegister.getString(3),
				itineraryRegister.getInt(4), itineraryRegister.getString(5), 
				itineraryRegister.getInt(6), itineraryRegister.getDouble(7),	itineraryRegister.getBoolean(8));
	}
	
	private Itinerary toItineraryInserrt(ResultSet itineraryRegister) throws SQLException {
		return new Itinerary(itineraryRegister.getInt(1), itineraryRegister.getInt(2),
				itineraryRegister.getInt(3), itineraryRegister.getInt(4), itineraryRegister.getDouble(5),
				itineraryRegister.getBoolean(6));
	}

	@Override
	public int insert(Itinerary itinerary) {
		try {
			String sql = "INSERT INTO attractions (name, cost, duration, capacity, type, description, image, is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setInt(i++, itinerary.getUsername());
			statement.setInt(i++, itinerary.getAttraction());
			statement.setInt(i++, itinerary.getCost());
			statement.setDouble(i++, itinerary.getDuration());
			statement.setBoolean(i++, itinerary.getPromotion());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Itinerary itinerary) {
		try {
			String sql = "UPDATE attractions SET name = ?, cost = ?, duration = ?, capacity = ?, type = ?, description = ?, image = ?, is_active = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setInt(i++, itinerary.getUsername());
			statement.setInt(i++, itinerary.getAttraction());
			statement.setInt(i++, itinerary.getCost());
			statement.setDouble(i++, itinerary.getDuration());
			statement.setBoolean(i++, itinerary.getPromotion());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Itinerary itinerary) {
		try {
			String sql = "UPDATE attractions SET is_active = 0 WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, itinerary.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM attractions";
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
	public List<Itinerary> findItinerary(Integer id) {
		try {
			String sql = "SELECT i.id, u.username, a.name, i.cost, i.duration, i.promotion FROM itinerary i\r\n"
					+ "INNER JOIN users u ON u.id = i.username\r\n"
					+ "INNER JOIN attractions a ON a.id = i.attraction\r\n"
					+ "WHERE u.id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			statement.setInt(1, id);

			List<Itinerary> itineraries = new LinkedList<Itinerary>();
			while (resultados.next()) {
				itineraries.add(toItinerary(resultados));
			}

			return itineraries;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Itinerary itinerary, User user, Attraction attraction, Promotion promotion) {
		try {
			String sql = "INSERT INTO itinerary (username, attraction, cost, duration, promotion) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setInt(i++, user.getId());
			statement.setInt(i++, attraction.getId());
			statement.setInt(i++, itinerary.getCost());
			statement.setDouble(i++, itinerary.getDuration());
			statement.setInt(i++, promotion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
