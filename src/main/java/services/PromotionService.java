package services;

import java.util.List;

import model.Attraction;
import model.Promotion;
import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class PromotionService {
	public List<Promotion> list() {
		return DAOFactory.getPromotionDAO().findAll();
	}

	public Promotion(Integer id, String name, Integer cost, String attraction1, String attraction2, String attraction3,
			String image) {

		Promotion promotion = new Promotion(-1, name, cost, attraction1, attraction2, attraction3, image);

		if (promotion.isValid()) {
			PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
			promotionDAO.insert(promotion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promotion;
	}

	public Promotion(Integer id, String name, Integer cost, String attraction1, String attraction2, String attraction3,
			String image) {

		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		Promotion promotion = promotionDAO.find(id);

		promotion.setName(name);
		promotion.setCost(cost);
		promotion.getAttraction1();
		promotion.getAttraction2();
		promotion.getAttraction3()
		promotion.setImage(image);
		

		if (promotion.isValid()) {
			promotionDAO.update(promotion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promotion;
	}

	public void delete(Integer id) {
		Attraction attraction = new Attraction(id, null, null, null, null, null, null, null, false);

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}

	public Attraction find(Integer id) {
		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		return attractionDAO.find(id);
	}
}
