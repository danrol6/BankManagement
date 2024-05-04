package com.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class DbCon.
 * Objects of this class represent a connection to a DB.
 * @author Brently
 */
public class DbCon {
	
	private static Connection con = null;
	

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "";
	private static final String PASSWORD = "";
	
	/**
	 * Opens DB connection.
	 * @return
	 */
	public static Connection getConnection() {
		if(con == null) {
			try {
				// For mySQL use
				// Class.forName("");
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				con = DriverManager.getConnection(URL, USER, PASSWORD);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	/**
	 * Closes DB connection.
	 */
	public static void closeConnection() {
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
			con = null;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
