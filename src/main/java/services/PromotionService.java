package services;

import java.util.List;


import model.Promotion;
import persistence.PromotionDAO;
import persistence.commons.DAOFactory;

public class PromotionService {
	public List<Promotion> list() {
		return DAOFactory.getPromotionDAO().findAll();
	}

	public Promotion create(Integer id, String name, Integer cost, String attraction1, String attraction2, String attraction3,
			String image, Boolean isActive, Double duration) {

		Promotion promotion = new Promotion(-1, name, cost, attraction1, attraction2, attraction3, image, isActive, duration);

		if (promotion.isValid()) {
			PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
			promotionDAO.insert(promotion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promotion;
	}

	public Promotion update(Integer id, String name, Integer cost, String attraction1, String attraction2, String attraction3,
			String image, Boolean isActive, Double duration) {

		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		Promotion promotion = promotionDAO.find(id);

		promotion.setName(name);
		promotion.setCost(cost);
		promotion.getAttraction1();
		promotion.getAttraction2();
		promotion.getAttraction3();
		promotion.setImage(image);
		promotion.setIsActive(isActive);
		promotion.setDuration(duration);

		if (promotion.isValid()) {
			promotionDAO.update(promotion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promotion;
	}

	public void delete(Integer id) {
		Promotion promotion = new Promotion(id, null, null, null, null, null, null, false, null);

		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		promotionDAO.delete(promotion);
	}

	public Promotion find(Integer id) {
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		return promotionDAO.find(id);
	}
}
