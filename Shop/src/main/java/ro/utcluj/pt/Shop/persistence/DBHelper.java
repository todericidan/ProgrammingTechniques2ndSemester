package ro.utcluj.pt.Shop.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	
	public static Connection getConnection() throws SQLException {
		
		Connection connection = null;
		
		Properties connectionProperties = new Properties();
		connectionProperties.put("user", "root");
		connectionProperties.put("password", "");

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop",connectionProperties);
		
		return connection;
	}
}
