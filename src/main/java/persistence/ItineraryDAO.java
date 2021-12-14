package persistence;

import java.util.List;

import model.Itinerary;
import persistence.commons.GenericDAO;

public interface ItineraryDAO extends GenericDAO<Itinerary> {

	public abstract List<Itinerary> findAll();
}