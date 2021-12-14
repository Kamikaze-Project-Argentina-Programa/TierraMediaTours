package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Itinerary;
import persistence.ItineraryDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ItineraryDAOImpl  implements ItineraryDAO { 
	 
	 public List<Itinerary> findAll() { 
	  try { 
	   String sql = "SELECT * FROM attractions WHERE is_active = 1"; 
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
	   String sql = "SELECT * FROM attractions WHERE id = ? AND is_active = 1"; 
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
	  return new Itinerary(itineraryRegister.getInt(1), itineraryRegister.getString(2), 
			  itineraryRegister.getString(3), itineraryRegister.getInt(4), itineraryRegister.getDouble(5), 
			  itineraryRegister.getBoolean(6)); 
	 } 
	 
	 @Override 
	 public int insert(Itinerary itinerary) { 
	  try { 
	   String sql = "INSERT INTO attractions (name, cost, duration, capacity, type, description, image, is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
	   Connection conn = ConnectionProvider.getConnection(); 
	 
	   PreparedStatement statement = conn.prepareStatement(sql); 
	   int i = 1; 
	   statement.setString(i++, itinerary.getUsername()); 
	   statement.setString(i++, itinerary.getAttraction()); 
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
	   statement.setString(i++, itinerary.getUsername()); 
	   statement.setString(i++, itinerary.getAttraction()); 
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
	 
}
