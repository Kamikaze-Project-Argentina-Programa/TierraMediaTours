package testdao;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Attraction;
import model.User;
import persistence.impl.AttractionDAOImpl;
import persistence.impl.UserDAOImpl;

public class TestUsers {

	

	@Test
	public void testAttractions() {
		UserDAOImpl user = new UserDAOImpl();
		List<User> theUsers = user.findAll();
		
		System.out.println("");
		System.out.println(theUsers.toString());
	}
	
}
