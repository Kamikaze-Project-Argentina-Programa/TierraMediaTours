package services;

import java.util.List;

import model.Attraction;
import model.User;
import persistence.AttractionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class UserService {

 public List<User> list() {
  return DAOFactory.getUserDAO().findAll();
 }

 public User create(String username, String password, Boolean admin, Integer money, 
		 Double time, Integer preferences, String preferencetype, Boolean isActive) {
  User user = new User(-1, username, password, admin, money, time, preferences, preferencetype, isActive);
  user.setPassword(password);

  if (user.isValid()) {
   DAOFactory.getUserDAO().insert(user);
   // XXX: si no devuelve "1", es que hubo más errores
  }

  return user;
 }
 
 public User update(Integer id, String username, String password, Boolean admin, Integer money, 
		 Double time, Integer preferences, String preferencetype, Boolean isActive) {

		UserDAO userDAO = DAOFactory.getUserDAO();
		User user = userDAO.find(id);

		user.setUsername(username);
		user.setPassword(password);
		user.setAdmin(admin);
		user.setMoney(money);
		user.setTime(time);
		user.setPreferences(preferences);
		user.setPreferencetype(preferencetype);
		user.setIsActive(isActive);

		if (user.isValid()) {
			userDAO.update(user);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return user;
	}
 public void delete(Integer id) {
		User user = new User(id, null, null, false, null, null, null, null, false);

		UserDAO userDAO = DAOFactory.getUserDAO();
		userDAO.delete(user);
	}

	public User find(Integer id) {
		UserDAO userDAO = DAOFactory.getUserDAO();
		return userDAO.find(id);
	}
 
 public User findById(Integer id) {
	return DAOFactory.getUserDAO().find(id);
 }
 
}