package patterns;


import java.sql.DriverManager;
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

public class SingletonWritter {
	
	// Variable to connect with the DB
	private java.sql.Connection con = null;
	private java.sql.Statement stat = null;
	private ResultSet res = null;
	
	//Single instance that live here
	private static SingletonWritter instance = new SingletonWritter();
	
	//Private constructor
	private SingletonWritter () {}
	
	//Singleton getter
	public static SingletonWritter getInstance() {
		return instance;
	}
	
//	Connecting with the database
//	 https://www.caelum.com.br/apostila-java-web/bancos-de-dados-e-jdbc/#a-conexo-em-java
//	https://www.youtube.com/watch?v=eakDOoljKDU
//https://www.youtube.com/watch?v=nbAYB6HyTQI
	
	public void ConnectToDatabase() {
		//Strings gave by Amilcar to make the connection w/ the database
		// The driver is extremely important, there is no connection without the driver
		String driver = "com.mysql.jdbc.Driver";
		String server = "jdbc:mysql://52.50.23.197:3306/world";
		String user = "cctstudent";
		String password = "Pass1234!";
		
		try {
			//Inserting the Drive into the class
			Class.forName(driver);
			//Assigning the DriverManager connection using the connection strings
			this.con = DriverManager.getConnection(server, user, password);
			//Creating a new Statement from the assigned connection
			this.stat = this.con.createStatement();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error: " + e.getMessage(), //message
			        "Error",  
			        JOptionPane.INFORMATION_MESSAGE);
				
	}
	}
		
	//Method to disconnect with the database
	public void DisconnectDatabase() {
		//Try catch to disconnect the DB
		try {
			//Command to end the connection
			this.con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error: " + e.getMessage(), //Message
			        "Error", // Window title 
			        JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
	
	
	
	


