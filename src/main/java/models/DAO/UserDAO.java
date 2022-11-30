package models.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import core.Mapper.ResultSetMapper.UserResultSetMapper;
import models.Bean.User;

public class UserDAO extends BaseDAO<User>{
	public UserDAO() {
		super(new UserResultSetMapper());
	}
	
	public User findByUsername(String username) {
		return this.getRecordSingle("SELECT * FROM USER WHERE USERNAME = ?", new Object[] { username });
	}
	
	public boolean add(User user) {
		String query = """
				INSERT INTO USER(ID, NAME, USERNAME, PASSWORD, REGISTEREDAT, ROLEID)
				VALUE(?, ?, ?, ?, ?, ?)
		""";
		return this.executeQuery(query, new Object[] { user.getID(), user.getName(), user.getUsername(), user.getPassword(), user.getRegisteredAt(), user.getRoleID() });
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		return this.getRecordSingle("SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?", new Object[] { username, password });
	}
	
	public ArrayList<User> getNewUserInDay(Date date) {
		return this.getRecordArray("SELECT * FROM USER WHERE DATE(REGISTEREDAT) = ?", new Object[] { new SimpleDateFormat("yyyy-MM-dd").format(date) });
	}
}
