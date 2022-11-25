package models.Bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User {
	private String ID;
	private String name;
	private String username;
	private String password;
	private Timestamp registeredAt;
	private String roleID;
	
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Timestamp getRegisteredAt() {
		return registeredAt;
	}
	public String getRoleID() {
		return roleID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRegisteredAt(Timestamp registeredAt) {
		this.registeredAt = registeredAt;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	
}
