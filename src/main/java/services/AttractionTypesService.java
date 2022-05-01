package services;

import java.util.List;

import model.AttractionTypes;
import persistence.AttractionTypesDAO;
import persistence.commons.DAOFactory;

public class AttractionTypesService {

	public List<AttractionTypes> list() {
		return DAOFactory.getAttractionTypesDAO().findAll();
	}

	public AttractionTypes create(String type, Boolean isActive) {

		AttractionTypes attractionTypes = new AttractionTypes(-1, type, isActive);

		AttractionTypesDAO attractionTypesDAO = DAOFactory.getAttractionTypesDAO();
		attractionTypesDAO.insert(attractionTypes);

		return attractionTypes;
	}

	public AttractionTypes update(Integer id, String type, Boolean isActive) {

		AttractionTypesDAO attractionTypesDAO = DAOFactory.getAttractionTypesDAO();
		AttractionTypes attractionTypes = attractionTypesDAO.find(id);

		attractionTypes.setType(type);
		attractionTypes.setIsActive(isActive);		
		attractionTypesDAO.update(attractionTypes);
 

		return attractionTypes;
	}

	public void delete(Integer id) {
		AttractionTypes attractionTypes = new AttractionTypes(id, null, false);

		AttractionTypesDAO attractionTypesDAO = DAOFactory.getAttractionTypesDAO();
		attractionTypesDAO.delete(attractionTypes);
	}

	public AttractionTypes find(Integer id) {
		AttractionTypesDAO attractionTypesDAO = DAOFactory.getAttractionTypesDAO();
		return attractionTypesDAO.find(id);
	}

}
