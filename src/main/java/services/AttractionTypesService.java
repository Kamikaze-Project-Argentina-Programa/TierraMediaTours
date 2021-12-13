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

//		if (attractionTypes.isValid()) {
//			AttractionTypesDAO attractionTypesDAO = DAOFactory.getAttractionTypesDAO();
//			attractionTypesDAO.insert(attractionTypes);
//			// XXX: si no devuelve "1", es que hubo más errores
//		}

		return attractionTypes;
	}

	public AttractionTypes update(Integer id, String type, Boolean isActive) {

		AttractionTypesDAO attractionTypesDAO = DAOFactory.getAttractionTypesDAO();
		AttractionTypes attractionTypes = attractionTypesDAO.find(id);

		attractionTypes.setType(type);
		attractionTypes.setIsActive(isActive);

//		if (attractionTypes.isValid()) {
//			attractionTypesDAO.update(attractionTypes);
//			// XXX: si no devuelve "1", es que hubo más errores
//		}

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
