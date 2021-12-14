package services;

import java.util.HashMap; 
import java.util.Map; 
 
import model.Attraction;
import model.Itinerary;
import model.User; 
import persistence.AttractionDAO;
import persistence.ItineraryDAO;
import persistence.UserDAO; 
import persistence.commons.DAOFactory; 
 
public class BuyAttractionService { 
 
 AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
 ItineraryDAO itineraryDAO = DAOFactory.getItineraryDAO(); 
 UserDAO userDAO = DAOFactory.getUserDAO(); 
 
 public Map<String, String> buy(Integer userId, Integer attractionId, Integer itineraryId) { 
  Map<String, String> errors = new HashMap<String, String>(); 
 
  User user = userDAO.find(userId); 
  Attraction attraction = attractionDAO.find(attractionId);
  Itinerary itinerary = itineraryDAO.find(itineraryId);
 
  if (!attraction.canHost(1)) { 
   errors.put("attraction", "No hay cupo disponible"); 
  } 
  if (!user.canAfford(attraction)) { 
   errors.put("user", "No tienes dinero suficiente"); 
  } 
  if (!user.canAttend(attraction)) { 
   errors.put("user", "No tienes tiempo suficiente"); 
  } 
 
  if (errors.isEmpty()) { 
   user.addToItinerary(attraction, itinerary); 
   attraction.host(1); 
 
   // no grabamos para no afectar la base de pruebas 
   attractionDAO.update(attraction); 
   userDAO.update(user); 
  } 
 
  return errors; 
 
 } 
 
}
