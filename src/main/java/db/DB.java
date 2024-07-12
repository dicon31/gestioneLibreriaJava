package db;

import java.sql.*;

//classe con cui gestiamo la connessione ad un db

public class DB {
	
	private static Connection connection;
	
	//singleton 
	
	public static Connection getDb() throws Exception {
		if(connection == null) {
			//creo la connessione (è la prima volta)
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:8889/bookshop",
					"root",
					"root");
		}
		
		return connection;
	}
	
	public static Statement getStmt() throws Exception {
		return getDb().createStatement();
	}
	
	public static PreparedStatement getPreparedStmt(String query) throws Exception {
		return getDb().prepareStatement(query);
	}
	 public static PreparedStatement getPPreparedStmt(String sql) throws SQLException {
	        return connection.prepareStatement(sql);
	    }
	

}
