package models.BO;

import models.Bean.Role;
import models.DAO.RoleDAO;

public class RoleBO {
	private RoleDAO roleDAO;
	public RoleBO() {
		roleDAO = new RoleDAO();
	}
	
	public Role getByName(String name) {
		if (name == null || name.isEmpty()) 
			return null;
		return roleDAO.getByName(name);
	}
	
	public Role getById(String id) {
		if (id == null || id.isEmpty()) 
			return null;
		return roleDAO.getById(id);
	}
}
