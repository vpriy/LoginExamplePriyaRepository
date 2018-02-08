package com.login.jsf.util;

/**
 * @author V.Vishnu Priya on 07/02/2018.
 * This is a database connectivity utility class which establishes the connection with the particular driver schema.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {

	/**
	 * This method creates the database connection .
	 * @return
	 */
	public static Connection getConnection() {
		try {
			//Registering the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establishing the connection
			Connection con = DriverManager.getConnection(
					"localhost:1521:vishnudb", "root", "123");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

	/**
	 * This method closes the database connection.
	 * @param con
	 */
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}