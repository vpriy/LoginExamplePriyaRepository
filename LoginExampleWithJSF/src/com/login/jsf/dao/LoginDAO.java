package com.login.jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.login.jsf.util.DataConnect;

/**
 * @author V.Vishnu Priya on 07/02/2018.
 * This class fetches the username and password from the database and compare it with the front end values passed. 
 * If the username and password does not match an error message is displayed as “Incorrect username and password”
 */
public class LoginDAO {

	public static boolean validate(String user, String password) throws ClassNotFoundException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//Calss the connection Util to establish the connection with DB
			con = DataConnect.getConnection();			
			//Query builder which builds the query for the table users
			ps = con.prepareStatement("Select uname, password from ASUI_OWNR.Users where uname = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);
			//Executes the query in the prepared statement & resultset is obtained.
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			//SQL exception will be logged here if any
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			//JDBC connection is closed.
			DataConnect.close(con);
		}
		return false;
	}
}
