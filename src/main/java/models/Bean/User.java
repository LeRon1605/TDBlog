package models.Bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	
	private String ID;
	
	@NotNull(message = "Họ và tên không được để trống")
	@Size(min = 10, message = "Họ và tên có độ dài ít nhất 10 kí tự")
	private String name;
	
	@NotNull(message = "Tên đăng nhập không được để trống")
	@Size(min = 6, message = "Tên đăng nhập có độ dài ít nhất 6 kí tự")
	private String username;
	
	@NotNull(message = "Mật khẩu không được để trống")
	@Size(min = 8, message = "Mật khẩu có độ dài ít nhất 8 kí tự")
	private String password;
	
	private String avatar;	
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
	public String getAvatar() {
		return avatar;
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
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
