package persistence;

import model.Attraction;
import model.AttractionTypes;
import model.Itinerary;
import model.User;
import persistence.commons.GenericDAO;

public interface UserDAO extends GenericDAO<User, Itinerary, Attraction, AttractionTypes> {
	public abstract User findByUsername(String username);
}
