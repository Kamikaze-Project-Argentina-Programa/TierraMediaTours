package persistence;

import java.util.List;

import model.Attraction;
import model.Itinerary;
import model.Promotion;
import model.User;
import persistence.commons.GenericDAO;

public interface ItineraryDAO extends GenericDAO<Itinerary, User, Attraction, Promotion> {

	public abstract List<Itinerary> findAll();
	
	public abstract List<Itinerary> findItinerary(Integer id);
	
}