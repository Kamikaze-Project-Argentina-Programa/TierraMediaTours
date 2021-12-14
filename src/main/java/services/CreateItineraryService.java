package services;

import model.Attraction;
import model.Itinerary;
import model.Promotion;
import model.User;
import persistence.commons.DAOFactory;

public class CreateItineraryService {
	public int list(Itinerary itinerary, User user, Attraction attraction, Promotion promotion) {
		
		return DAOFactory.getItineraryDAO().insert(itinerary, user, attraction, promotion);
	}
}
