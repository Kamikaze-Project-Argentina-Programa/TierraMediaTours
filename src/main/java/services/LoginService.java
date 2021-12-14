package services;

import java.util.List;

import model.AttractionTypes;
import model.Promotion;
import model.User; 
import model.nullobjects.NullUser;
import persistence.AttractionTypesDAO;
import persistence.PromotionDAO;
import persistence.UserDAO; 
import persistence.commons.DAOFactory; 
 
public class LoginService { 
 
 public User login(String username, String password) { 
  UserDAO userDao = DAOFactory.getUserDAO(); 
     User user = userDao.findByUsername(username); 
      
     if (user.isNull() || !user.checkPassword(password)) { 
      user = NullUser.build(); 
     } 
     return user; 
 } 
 public List<Promotion> login() { 
	  PromotionDAO promotionDAO = DAOFactory.getPromotionDAO(); 
	  List<Promotion> promotions = promotionDAO.findAll(); 
	     return promotions; 
	 } 
}