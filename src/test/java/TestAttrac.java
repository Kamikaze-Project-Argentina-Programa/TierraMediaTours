

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Attraction;
import persistence.impl.AttractionDAOImpl;

public class TestAttrac {

	@Test
	public void test() {
		AttractionDAOImpl attractionDAO = new AttractionDAOImpl();
		List<Attraction>lasAttraction = attractionDAO.findAll();
		
		System.out.println(lasAttraction.toString());
	}

}
