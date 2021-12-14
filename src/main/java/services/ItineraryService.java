package services;

import java.util.List;

import model.Itinerary;
import persistence.ItineraryDAO;
import persistence.commons.DAOFactory;

public class ItineraryService {
	public List<Itinerary> list() {
		return DAOFactory.getItineraryDAO().findAll();
	}

	public Itinerary create(String username, String attraction, Integer cost, Double duration, Boolean promotion) {

		Itinerary itinerary = new Itinerary(-1, username, attraction, cost, duration, promotion);

		if (itinerary.isValid()) {
			ItineraryDAO itineraryDAO = DAOFactory.getItineraryDAO();
			itineraryDAO.insert(itinerary);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return itinerary;
	}

	public Itinerary update(Integer id, String username, String attraction, Integer cost, Double duration,
			Boolean promotion) {

		ItineraryDAO itineraryDAO = DAOFactory.getitineraryDAO();
		Itinerary itinerary = itineraryDAO.find(id);

		attraction.setName(name);
		attraction.setCost(cost);
		attraction.setDuration(duration);
		attraction.setCapacity(capacity);
		attraction.setType(type);
		attraction.setDescription(description);
		attraction.setImage(image);
		attraction.setIsActive(isActive);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
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
