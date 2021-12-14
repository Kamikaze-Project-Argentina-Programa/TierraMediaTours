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

		return itinerary;
	}

	public Itinerary find(Integer id) {
		ItineraryDAO itineraryDAO = DAOFactory.getItineraryDAO();
		return itineraryDAO.find(id);
	}

}
