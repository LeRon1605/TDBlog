package core.Mapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Bean.User;

public class UserResultSetMapper implements IResultSetMapper<User>{

	@Override
	public User map(ResultSet row) {
		try {
			if (row == null || row.getRow() == 0) 
				return null;
			User user = new User();
			user.setID(row.getString("ID"));
			user.setName(row.getString("NAME"));
			user.setUsername(row.getString("USERNAME"));
			user.setPassword(row.getString("PASSWORD"));
			user.setRegisteredAt(row.getTimestamp("REGISTEREDAT"));
			user.setRoleID(row.getString("ROLEID"));
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

}
