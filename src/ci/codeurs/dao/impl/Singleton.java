package ci.codeurs.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	private static final String URL      = "jdbc:mysql://localhost:3306/synthese_ihm";
	private static final String LOGIN    = "root";
	private static final String PASSWORD = "";
	private static Connection conn;
	
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(URL,LOGIN,PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	

}
