package services;

import java.util.List;

import model.Attraction;
import model.Itinerary;
import model.User;
import persistence.ItineraryDAO;
import persistence.commons.DAOFactory;

public class ItineraryService {
	
	public List<Itinerary> list() {
		return DAOFactory.getItineraryDAO().findAll();
	}

	public Itinerary create(Integer userId, List<Attraction> attractions, Integer cost, Double duration,
			Boolean promotion) {
		UserService userService = new UserService();
		User user = userService.findById(userId);

		Itinerary itinerary = new Itinerary(-1, user, cost, duration, promotion);
		itinerary.getAttractions().addAll(attractions);

		DAOFactory.getItineraryDAO().insert(itinerary);
		return itinerary;
	}

	public void update(Itinerary itinerary, Attraction attraction) {
		Integer calculatedCost = itinerary.getCost() + attraction.getCost();
		Double calculatedDuration = itinerary.getDuration() + attraction.getDuration();
		
		itinerary.setCost(calculatedCost);
		itinerary.setDuration(calculatedDuration);
		itinerary.getAttractions().add(attraction);
		
		DAOFactory.getItineraryDAO().update(itinerary);
	}

	public Itinerary find(Integer id) {
		ItineraryDAO itineraryDAO = DAOFactory.getItineraryDAO();
		return itineraryDAO.find(id);
	}

}
