package patterns;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * 
 * This is the singleton class of the program.
 * As all the logs MUST go to the same file, there can't
 * be more than one instance of it. Otherwise there
 * will conflict of versions. 
 * 
 * @author Adriana
 *
 */
public class DataSourceSingletonWritter {
	
	private String db = "jdbc:mysql://localhost:3306/country";
	private String un = "root";
	private String pw = "123";
	
	/*
	 * making those bad boys global, to be able to access
	 * them from any of the methods
	 */
	private Connection conn;
	private Statement stmt;
	
	//Single instace that live here
	private static DataSourceSingletonWritter instace = new DataSourceSingletonWritter ();
	
	//Private constructor
	private DataSourceSingletonWritter() {
		
		try {
			//Get a connection to the database
			conn = (Connection) DriverManager.getConnection(db, un, pw);
			
			//Get a statement from the connection
			stmt= (Statement) conn.createStatement();
		}
		catch (SQLException se) {
			System.out.println("SQL Exception:");
			
			//Loop through the SQL Exceptions
			while (se !=null) {
				System.out.println( "State: " + se.getSQLState ()  );
				System.out.println( "Message: " + se.getMessage () );
				
				se = se.getNextException ();
			}
		}
		catch (Exception e) {
			System.out.println( e );
			
		}
	}

	//Singleton getter
	public static DataSourceSingletonWritter getInstance () {
		return getInstance();
	}
	
	//generic method to do any select statement that pass in 
	//using the query available
	public boolean save (String query) {
		
		try {
			stmt.execute(query);
			return true;
		}catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		}
	}
}

//Separate method to close the statement and the conection
public void closing () {
	try {
		stmt.close();
		conn.close();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}