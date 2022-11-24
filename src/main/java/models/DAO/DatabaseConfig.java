package models.DAO;

public class DatabaseConfig {
	public static String host = "localhost:3306";
	public static String name = "data";
	public static String username = "root";
	public static String password = "";
	
	public static String getConnectionString() {
		return "jdbc:mysql://" + host + "/" + name; 
	}
}
