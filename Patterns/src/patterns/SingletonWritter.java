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
		// TODO Auto-generated method stub
		//Strings gave by Amilcar to make the connection w/ the database
		// The driver is extremely important, there is no connection without the driver
		String driver = "com.mysql.jdbc.Driver";
		String server = "jdbc:mysql://52.50.23.197:3306/world";
		String user = "cctstudent";
		String password = "Pass1234!";
		
		// Try catch for attempting to connect to db
		try {
			//Inserting the Drive into the class
			Class.forName(driver);
			//Assigning the DriverManager connection using the connection strings
			this.con = DriverManager.getConnection(server, user, password);
			//Creating a new Statement from the assigned connection
			this.stat = this.con.createStatement();
		} catch (Exception e) {
			//showing an error that may occur on the DB
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
	
	public void GetCountryCode(String code) {
		// TODO Auto-generated method stub
		try {
			//Db Query that returns all records ordered by Code
			String sql = "SELECT Code, Name, Continent, SurfaceArea, HeadOfState FROM country WHERE Code = '" + code + "'";
			this.res = this.stat.executeQuery(sql);//execting the query and send the result to the ResultSet
			// "Zeroing" the sql String that will display the results on the screen
			sql = "";
			//while there is a register its goes here
			while (this.res.next()) {
				//Addding the register in a String SQL
				sql += "Code: " + this.res.getString("Code") + " Name: " + this.res.getString("Name") +" Continent: " + this.res.getString("Continent")+" Surface Area: " + this.res.getFloat("SurfaceArea") +" Head of State: " + this.res.getString("HeadOfState");
				//Adding a break line on the String
				sql += "\n";	
			}
			
			if (sql =="") {
				JOptionPane.showMessageDialog(null,
						"No country was found.", //message
				        "World", // window title 
				        JOptionPane.INFORMATION_MESSAGE);
			}else {
				//
				JOptionPane.showMessageDialog(null,
						sql, //message
				        "World", // window title 
				        JOptionPane.INFORMATION_MESSAGE);
			}
						
		}catch  (Exception e) {//Enter catch if there are any other problems, such as connection etc.
			//showing an error show on the db
			JOptionPane.showMessageDialog(null,
					"Error: " + e.getMessage(), //message
			        "Error", // window title 
			        JOptionPane.INFORMATION_MESSAGE);
		}
	}
		public void GetCountryName (String name) {
			// TODO Auto-generated method stub
			
			try {
				// Query of db that returns all records ordered by Code
				String sql = "SELECT Code, Name, Continent, SurfaceArea, HeadOfState FROM country WHERE NAme = '" +name+ "'";
				this.res= this.stat.executeQuery(sql);
				sql ="";
				while (this.res.next()) {
					
					//Adding a register to the string sql
					sql+="Code: " +this.res.getString("Code") + "Name" + this.res.getString("Name") +" Continent: " +this.res.getString("Continent")+ "Surface Area: " + this.res.getFloat("SurfaceArea") + "Head of State: " + this.res.getString("HeadOfState");
					//Adding a break line on the String
					sql +="n";
				}
			
				if (sql =="") {
					
					JOptionPane.showMessageDialog(null,
							"No country was found.", //message
					        "World", 
					        JOptionPane.INFORMATION_MESSAGE);
					}else {
						//in case any error is found
						JOptionPane.showMessageDialog(null,
								sql, //message
								"World", 
								JOptionPane.INFORMATION_MESSAGE);
								
					}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Error:" + e.getMessage(),
						"Error",
						JOptionPane.INFORMATION_MESSAGE);
						
					}
			}
		
		public void GetAllRecords () {
			// TODO Auto-generated method stub
			try {
				// Query of db that returns all records ordered by Code
				String sql = "SELECT Code, Name, Continent, SurfaceArea, HeadOfState FROM country";
				this.res = this.stat.executeQuery(sql);
				sql = "";
				while (this.res.next ()) {
					// Adding one record at a time in the SQL String, until everyone has been add
					sql += "Code: " + this.res.getString("Code") + "Name: " + this.res.getString("Name") +" Continent: " + this.res.getString("Continent")+" Surface Area: " + this.res.getFloat("SurfaceArea") +" Head of State: " + this.res.getString("HeadOfState");
					//Adding a break line on the string
					sql += "\n";
				}
				//showing the result on the console
				System.out.println(sql);
				JOptionPane.showMessageDialog(null, 
						sql, //message
						"Results",
						JOptionPane.INFORMATION_MESSAGE);
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Error:" + e.getMessage(),
						"Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		public void InsertNewCountry (String code, String name, String continent, float sufaceAreaFloat, String headofstate) {
			// TODO Auto-generated method stub)
			
			try {
				//Initializing the String that will be used to insert the database
				String sql = "INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState"
						+ "VALUES ('" +code +"', '"+name+"', "+" '"+ continent +"', '"+ sufaceAreaFloat +"', '"+headofstate +"')";
				// Command that executes the SQL string command on the database
				this.stat.executeUpdate(sql);
				
				//To show the message on the panel
				JOptionPane.showMessageDialog(null,
						name + "was inserted into the database world.", //message
						"Results", 
						JOptionPane.INFORMATION_MESSAGE);
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,
					"Error: " + e.getMessage() + "\nPlease, try it again.",
					 "Error",
					 JOptionPane.INFORMATION_MESSAGE);
			}
		}
}
	
	


