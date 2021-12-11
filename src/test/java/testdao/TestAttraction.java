package testdao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Attraction;
import persistence.impl.AttractionDAOImpl;

public class TestAttraction {

	@Test
	public void testLlamadaAttraction() {
		AttractionDAOImpl attraction = new AttractionDAOImpl();
		List<Attraction> theAttractions = attraction.findAll();
		
		System.out.println(theAttractions.toString());
	}

}
