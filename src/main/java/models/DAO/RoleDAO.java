package models.DAO;

import core.Mapper.ResultSetMapper.IResultSetMapper;
import core.Mapper.ResultSetMapper.RoleResultSetMapper;
import models.Bean.Role;

public class RoleDAO extends BaseDAO<Role> {

	public RoleDAO() {
		super(new RoleResultSetMapper());
	}
	
	public Role getById(String id) {
		return this.getRecordSingle("SELECT * FROM ROLE WHERE ID = ?", new Object[] { id });
	}
	
	public Role getByName(String name) {
		return this.getRecordSingle("SELECT * FROM ROLE WHERE NAME = ?", new Object[] { name });
	}
	
}
