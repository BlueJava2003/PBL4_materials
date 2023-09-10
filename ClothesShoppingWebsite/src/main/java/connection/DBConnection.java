package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static Connection connection = null;
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	public static Connection getConnection() {
		Properties props = DBProvider.getProps();
		if(connection == null) {
			try {
				Class.forName(props.getProperty(DBConstants.DRIVER));
				connection = DriverManager.getConnection(
						props.getProperty(DBConstants.URL), 
						props.getProperty(DBConstants.USER), 
						props.getProperty(DBConstants.PASS));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static void setConnection(Connection connection) {
		DBConnection.connection = connection;
	}
	
}
