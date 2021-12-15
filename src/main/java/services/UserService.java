package services;

import java.util.List;

import model.User;
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
 
 public User findById(Integer id) {
	return DAOFactory.getUserDAO().find(id);
 }
 
}