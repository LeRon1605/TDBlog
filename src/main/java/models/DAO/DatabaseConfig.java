package models.DAO;

public class DatabaseConfig {
	public static String host = "localhost:3306";
	public static String name = "TDBlog";
	public static String username = "root";
		public static String password = "ronle75";
	
	public static String getConnectionString() {
		return "jdbc:mysql://" + host + "/" + name + "?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterSetResults=utf8&characterEncodi‌​ng=UTF-8"; 
	}
}
