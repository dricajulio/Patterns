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
	
	private java.sql.Connection con = null;
	private java.sql.Statement stat = null;
	private ResultSet res = null;
	
	//Single instance that live here
	private static SingletonWritter instace = new SingletonWritter ();
	
	//Private constructor
	private SingletonWritter () {}
	
	//Singleton getter
	public static SingletonWritter getInstace () {
		return instace;
	}
	
//	Connecting with the database
//	 https://www.caelum.com.br/apostila-java-web/bancos-de-dados-e-jdbc/#a-conexo-em-java
//	https://www.youtube.com/watch?v=eakDOoljKDU
	public void ConnectToDatabase() {
		//Strings gave by Amilcar to make the connection w/ the database
		// The driver is extremely important, there is no connection whitout the driver
		String driver = "com.mysql.jdbc.Driver";
		String server = "jdbc:mysql://52.50.23.197:3306/world";
		String user = "cctstudent";
		String password = "Pass1234!";
		
		try {
			Class.forName(driver);
			this.con = DriverManager.getConnection (server, user, password);
			this.stat = this.con.createStatement();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error: " + e.getMessage(), //message
			        "Error", // Window title 
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
	
	
	
	


