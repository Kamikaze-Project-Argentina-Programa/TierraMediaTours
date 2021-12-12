package services;

import java.util.HashMap;
import java.util.Map;


import model.Promotion;
import model.User;
import persistence.PromotionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class BuyPromotionService {
	PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
	UserDAO userDAO = DAOFactory.getUserDAO();

	public Map<String, String> buy(Integer userId, Integer promotionId) {
		Map<String, String> errors = new HashMap<String, String>();

		User user = userDAO.find(userId);
		Promotion promotion = promotionDAO.find(promotionId);

		if (!promotion.canHost(1)) {
			errors.put("promotion", "No hay cupo disponible");
		}
		if (!user.canAffordPromotion(promotion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.canAttendPromotion(promotion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.addToItinerary(promotion);
			promotion.host(1);

			// no grabamos para no afectar la base de pruebas
			promotionDAO.update(promotion);
			userDAO.update(user);
		}

		return errors;

	}

}
