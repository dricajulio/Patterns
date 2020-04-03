package patterns;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * 
 * This is the singleton class of the program. As all the logs MUST go to the
 * same file, there can't be more than one instance of it. Otherwise there will
 * conflict of versions.
 * 
 * @author Adriana
 *
 */
public class DataSourceSingletonWritter {

	//parameters sent by Amilcar
	private String db = "jdbc:mysql://52.50.23.197:3306/world";
	private String un = "cctstudent";
	private String pw = "Pass1234!";

	/*
	 * making those bad boys global, to be able to access them from any of the
	 * methods
	 */
	private Connection conn;
	private Statement stmt;

	// Single instace that live here
	private static DataSourceSingletonWritter instance = new DataSourceSingletonWritter();

	// constructor
	public DataSourceSingletonWritter() {

		try {
			// Get a connection to the database
			conn = (Connection) DriverManager.getConnection(db, un, pw);

			// Get a statement from the connection
			stmt = (Statement) conn.createStatement();
		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	// Singleton getter!!!
	public static DataSourceSingletonWritter getInstance() {
		return instance;
	}

	// Generic method to do any insert statement that pass in using the query
	// variable
	public ResultSet select(String query) {
		// Execute the query
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	// Generic method to do any insert statement that pass in using the query
	// variable
	public boolean save(String query) {

		try {

			stmt.execute(query);
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	// Separated method to close the statement connection
	public void closing() {
		try {
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
