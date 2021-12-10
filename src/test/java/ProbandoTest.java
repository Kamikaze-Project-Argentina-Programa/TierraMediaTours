import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Attraction;
import persistence.impl.AttractionDAOImpl;

public class ProbandoTest {

	@Test
	public void testLlamadaAttraction() {
		AttractionDAOImpl attraction = new AttractionDAOImpl();
		Attraction attraction1 = attraction.find(1);
		
		System.out.println(attraction1.toString());
	}

}
