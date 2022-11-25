package core.Mapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Bean.Role;

public class RoleResultSetMapper implements IResultSetMapper<Role>{

	@Override
	public Role map(ResultSet row) {
		try {
			if (row == null || row.getRow() == 0) 
				return null;
			Role role = new Role();
			role.setID(row.getString("ID"));
			role.setName(row.getString("NAME"));
			return role;
		} catch (SQLException e) {
			return null;
		}
	}

}
