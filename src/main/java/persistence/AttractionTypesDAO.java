package persistence;

import java.util.List;

import model.AttractionTypes;
import persistence.commons.GenericDAO;

public interface AttractionTypesDAO extends GenericDAO<AttractionTypes> {

	public abstract List<AttractionTypes> findAll();
}
