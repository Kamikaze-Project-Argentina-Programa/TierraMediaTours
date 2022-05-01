package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Attraction;
import model.Itinerary;
import model.User;
import persistence.AttractionDAO;
import persistence.ItineraryDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class BuyAttractionService {

	AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
	ItineraryDAO itineraryDAO = DAOFactory.getItineraryDAO();
	ItineraryService itineraryService = new ItineraryService();
	UserDAO userDAO = DAOFactory.getUserDAO();

	public Map<String, String> buy(Integer userId, Integer attractionId, Integer itineraryId) {
		Map<String, String> errors = new HashMap<String, String>();

		User user = userDAO.find(userId);
		Attraction attraction = attractionDAO.find(attractionId);

		if (!attraction.canHost(1)) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.canAfford(attraction)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.canAttend(attraction)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			Itinerary itinerary = itineraryDAO.find(itineraryId);
			if (itinerary == null) { // No existe el itinerario
				List<Attraction> attractions = new ArrayList<Attraction>();
				attractions.add(attraction);

				itineraryService.create(user.getId(), attractions, attraction.getCost(), attraction.getDuration(),
						false);
			}else { //existe el itinerario, lo actualizo.
				itineraryService.update(itinerary, attraction);
			}
			user.updateWalletAndTime(attraction);
			attraction.host(1);

			// actualizamos los datos en DB
			attractionDAO.update(attraction);
			userDAO.update(user);
		}

		return errors;

	}

}
