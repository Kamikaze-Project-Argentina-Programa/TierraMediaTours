package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.Attraction;
import model.User;
import persistence.commons.ConnectionProvider;
import persistence.impl.AttractionDAOImpl;
import persistence.impl.UserDAOImpl;

public class ProbandoTest {

	public void testConnectionOK() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		Assert.assertNotNull(connection);
	}

	@Test
	public void testFindById() throws SQLException {
		UserDAOImpl usuariosDAO = new UserDAOImpl();

		User user = usuariosDAO.findByUsername("leo");
		
		System.out.print(user.toString());
	}
	
	@Test
	public void testFindAll() throws SQLException {
		AttractionDAOImpl attractionDAOImpl = new AttractionDAOImpl();
		
		List<Attraction> atraction = attractionDAOImpl.findAll();
		
		System.out.println(atraction);
		
	}
}
