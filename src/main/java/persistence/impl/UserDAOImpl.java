package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Attraction;
import model.AttractionTypes;
import model.Itinerary;
import model.User;
import model.nullobjects.NullUser;
import persistence.UserDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class UserDAOImpl implements UserDAO {
	public int insert(User user) {
		try {
			String sql = "INSERT INTO users (username, password, admin, money, time, preferences, is_active) VALUES (?, ?, ?, ?, ?, ?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, user.getUsername());
			statement.setString(i++, user.getPassword());
			statement.setBoolean(i++, user.getAdmin());
			statement.setInt(i++, user.getMoney());
			statement.setDouble(i++, user.getTime());
			statement.setInt(i++, user.getPreferences());
			statement.setBoolean(i++, user.getIsActive());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(User user) {
		try {
			String sql = "UPDATE users SET money = ?, time = ?, admin = ?, is_active = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getMoney());
			statement.setDouble(2, user.getTime());
			statement.setDouble(3, user.getId());
			statement.setBoolean(4, user.getAdmin());
			statement.setBoolean(5, user.getIsActive());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(User user) {
		try {
			String sql = "DELETE FROM USERS WHERE USERNAME = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public User findByUsername(String username) {
		try {
			String sql = "SELECT u.id, u.username, u.password, u.admin, u.money, u.time, u.preferences, at.type, u.is_active FROM users u \r\n"
					+ "INNER JOIN attraction_types at ON at.id = u.preferences\r\n"
					+ "WHERE u.username = ? AND u.is_active = 1";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet resultados = statement.executeQuery();
			User user = NullUser.build();
			if (resultados.next()) {
				user = toUserInsert(resultados);
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}

	public User find(Integer id) {
		try {
			String sql = "SELECT * FROM users WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			User user = NullUser.build();
			if (resultados.next()) {
				user = toUserInsert(resultados);
			}
			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM users";
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

	public List<User> findAll() {
		try {
			String sql = "SELECT u.id, u.username, u.password, u.admin, u.money, u.time, u.preferences, at.type, u.is_active FROM users u \r\n"
					+ "INNER JOIN attraction_types at ON at.id = u.preferences\r\n"
					+ "ORDER BY admin DESC, username";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			List<User> usuarios = new LinkedList<User>();
			while (resultados.next()) {
				usuarios.add(toUser(resultados));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private User toUser(ResultSet userRegister) throws SQLException {
		return new User(userRegister.getInt(1), userRegister.getString(2), userRegister.getString(3),
				userRegister.getBoolean(4), userRegister.getInt(5), userRegister.getDouble(6), userRegister.getInt(7), userRegister.getString(8),
				userRegister.getBoolean(9));
	}
	
	private User toUserInsert(ResultSet userRegister) throws SQLException {
		return new User(userRegister.getInt(1), userRegister.getString(2), userRegister.getString(3),
				userRegister.getBoolean(4), userRegister.getInt(5), userRegister.getDouble(6), userRegister.getInt(7),
				userRegister.getBoolean(8));
	}

	@Override
	public List<User> findOrderByType(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findItinerary(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(User t, Itinerary a, Attraction b, AttractionTypes c) {
		// TODO Auto-generated method stub
		return 0;
	}
}