package core.Mapper.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Bean.Tag;

public class TagResultSetMapper implements IResultSetMapper<Tag>{

	@Override
	public Tag map(ResultSet row) {
		try {
			if (row == null || row.getRow() == 0) 
				return null;
			Tag tag = new Tag();
			tag.setID(row.getString("ID"));
			tag.setName(row.getString("NAME"));
			return tag;
		} catch (SQLException e) {
			return null;
		}
	}

}
