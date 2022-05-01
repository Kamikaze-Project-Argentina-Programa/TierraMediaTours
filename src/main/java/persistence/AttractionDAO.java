package persistence;

import java.util.List;

import model.Attraction;
import model.AttractionTypes;
import model.Promotion;
import model.User;
import persistence.commons.GenericDAO;

public interface AttractionDAO extends GenericDAO <Attraction, User, Promotion, AttractionTypes> {
	public abstract List<Attraction> findOrderByType(Integer id);
	
}
