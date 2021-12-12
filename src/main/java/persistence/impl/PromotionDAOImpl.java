package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Promotion;
import persistence.PromotionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class PromotionDAOImpl implements PromotionDAO {

	public List<Promotion> findAll() {
		try {
			String sql = "SELECT p.id, at.type, p.cost, a.name, ab.name, ac.name, p.image, p.is_active , a.duration + ab.duration + ac.duration AS duration \r\n" 
					+ "FROM promotions p\r\n"
					+ "INNER JOIN attraction_types at ON at.id = p.name\r\n"
					+ "INNER JOIN attractions a ON a.id = p.attraction1\r\n"
					+ "INNER JOIN attractions ab ON ab.id = p.attraction2\r\n"
					+ "INNER JOIN attractions ac ON ac.id = p.attraction3 WHERE p.is_active = 1";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Promotion> promotions = new LinkedList<Promotion>();
			while (resultados.next()) {
				promotions.add(toPromotion(resultados));
			}

			return promotions;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Promotion find(Integer id) {
		try {
			String sql = "SELECT * FROM promotions WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Promotion promotion = null;
			if (resultados.next()) {
				promotion = toPromotion(resultados);
			}

			return promotion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Promotion toPromotion(ResultSet promotionRegister) throws SQLException {
		return new Promotion(promotionRegister.getInt(1), promotionRegister.getString(2), promotionRegister.getInt(3),
				promotionRegister.getString(4), promotionRegister.getString(5), promotionRegister.getString(6)
				, promotionRegister.getString(7),promotionRegister.getBoolean(8), promotionRegister.getDouble(9) );
	}

	@Override
	public int insert(Promotion promotion) {
		try {
			String sql = "INSERT INTO promotions (name, cost, attraction1, attraction2, attraction3, image, is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, promotion.getName());
			statement.setInt(i++, promotion.getCost());
			statement.setString(i++, promotion.getAttraction1());
			statement.setString(i++, promotion.getAttraction2());
			statement.setString(i++, promotion.getAttraction3());			
			statement.setString(i++, promotion.getImage());
			statement.setBoolean(i++, promotion.getIsActive());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Promotion promotion) {
		try {
			String sql = "UPDATE promotions SET name = ?, cost = ?, attraction1 = ?, attraction2 = ?, attraction3 = ?, image = ?, is_active = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, promotion.getName());
			statement.setInt(i++, promotion.getCost());
			statement.setString(i++, promotion.getAttraction1());
			statement.setString(i++, promotion.getAttraction2());
			statement.setString(i++, promotion.getAttraction3());			
			statement.setString(i++, promotion.getImage());
			statement.setBoolean(i++, promotion.getIsActive());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Promotion promotion) {
		try {
			String sql = "DELETE FROM promotions WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, promotion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM promotions";
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

}