package models.BO;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import core.Hash.MD5;
import models.Bean.User;
import models.DAO.RoleDAO;
import models.DAO.UserDAO;

public class UserBO extends BaseBO{
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	public UserBO() {
		userDAO = new UserDAO();
		roleDAO = new RoleDAO();
	}
	
	public boolean register(User user) {
		boolean isExist = userDAO.findByUsername(user.getUsername()) != null;
		if (isExist) {
			return false;
		}
			
		
		user.setID(generateID());
		user.setPassword(MD5.Hash(user.getPassword()));
		user.setRoleID(roleDAO.getByName("USER").getID());
		user.setRegisteredAt(Timestamp.from(Instant.now()));
		
		boolean result = userDAO.add(user);
		return result;
	}
	
	public User login(String username, String password) {
		if (username == null || username.length() < 6)
			return null;
		if (password == null || password.length() < 8) 
			return null;
		User user = userDAO.findByUsernameAndPassword(username, MD5.Hash(password));
		return user;
	}
}
