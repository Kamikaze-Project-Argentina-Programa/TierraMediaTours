package persistence;

import java.util.List;

import model.Attraction;
import model.AttractionTypes;
import model.Promotion;
import model.User;
import persistence.commons.GenericDAO;

public interface AttractionTypesDAO extends GenericDAO<AttractionTypes, User, Attraction, Promotion> {

	public abstract List<AttractionTypes> findAll();
}
