package testdao;

import java.util.List;
import org.junit.Test;
import model.Promotion;
import persistence.impl.PromotionDAOImpl;

public class TestPromotion {

	@Test
	public void testPromotions() {
	PromotionDAOImpl promotion = new PromotionDAOImpl();
	List<Promotion> thePromotions = promotion.findAll();
	
	System.out.println(thePromotions.toString());
}
}
