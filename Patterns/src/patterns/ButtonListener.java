package patterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener{

/*
 *  now the client does not have related with the DB, the client
Will only talk to the countrydao in terms of customer, in other words
The passing of data is going to be countries objects

 */
    MySQLCountryDAO db = new MySQLCountryDAO ();
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// building the string that is going to be printed to the console
				//String log = "Button " + arg0.getActionCommand() + " pressed. " + new Date() +"\n";
				// Using the singleton writer
				//sw.writeToFile(log);
					
				// Condition for each different feature depending on which button that was pressed
				if (arg0.getActionCommand() == "b2") {//B2 refer to button2 = new JButton("GET BY CODE");
					// asking a user to enter a code
					String code = JOptionPane.showInputDialog ("Please enter a valid code: ");
					// Using the singleton writer to access the database and generate information
					//db.getCountriesByCode(code);
					
					
					//starting the variable records
					String records = "";
					
					for (Country country : db.getCountriesByCode (code)) {
						
						// Concatenating the details of the current country of the list into the String records
						records = records + country.toString() + "\n";
					}
					
					//Checking if any country was add into the var records
					if (records.equals("")) {
						JOptionPane.showMessageDialog(null,
								"Any contry was found bt this code " + code, 
						        "Information", 
						        JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								records, //Aqui vai a msg a ser exibida para o user, neste caso será records, pois são todos os dados de todos os countries na database
						        "Information", // titulo da janela 
						        JOptionPane.INFORMATION_MESSAGE);
					}
					
									
					
				} else if (arg0.getActionCommand() == "b3") {//B3 refer to button3 = new JButton("GET BY NAME");
					// asking user to enter a name	
					String name = JOptionPane.showInputDialog ("Please enter a valid name: ");
					// Using the singleton writer to access the database e get information according with the name
					//db.getCountriesByName(name);
					
					String records ="";
					
					for (Country country : db.getCountriesByName(name)) {
						
						//Connecting the details of actual country inside the string list records
						records = records + country.toString() + "\n";
					}
					
					//Checking if any country was add into the var records
					if (records.equals("")) {
						JOptionPane.showMessageDialog(null,
								"Any contry was found bt this name: " + name, //the message that will be send to the user
						        "Information", 
						        JOptionPane.ERROR_MESSAGE);
					
					} else {
						JOptionPane.showMessageDialog(null,
								records, 
						        "Information",  
						        JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				
		       } else if (arg0.getActionCommand() == "b4") {//B4 refer to button4 = new JButton("INSERT NEW COUNTRY");
					
					//asking the user for the information needed to make the insert
					String code = JOptionPane.showInputDialog("Please, enter a valid code: ");
					
					String name = JOptionPane.showInputDialog("Please, enter a valid name: ");
					//A var continentOption is used to validate the continents that exist in the table country of the schema world
					int continentOption = 0;
				 //Starting a loop that will just stop when find corresponding continent number valid
					do {

						//Asking the user to pop in a number that correspond to the continent in the DB
						String continent = JOptionPane.showInputDialog("Please, enter the one of the following continents: \n"
																	+ "1-Asia\n"
																	+ "2-Europe\n"
																	+ "3-North America\n"
																	+ "4-Africa\n"
																	+ "5-Oceania\n"
																	+ "6-Antarctica\n"
																	+ "7-South America");
						// Transforming what user typed into int, because what the user typed is in the var String continent
						continentOption = Integer.parseInt(continent);
						// Condition that performs the validation, as it is only valid if the num of the continent is between 1 and 7
						if (continentOption < 1 | continentOption > 7) {
						continentOption = 0;//In case it is valid,transformed the number in 0
							//show error message 
							JOptionPane.showMessageDialog(null,
									"Error: Invalid option.", //message
							        "Error", 
							        JOptionPane.INFORMATION_MESSAGE);
						}
						
					} while (continentOption == 0);//repeating until the corresponding continent number is valid, in this case different from 0

		/*
		 * initializing the var continent that will be used with the exact continent name for insertion in db,
		 *  since it has to be a specific name in the database
		 */
					String continent = "null";
					//Assigning the number that the user typed to the corresponding continent
					if (continentOption == 1) {
						continent = "Asia";
					} 
					if (continentOption == 2) {
						continent = "Europe";
					}
					if (continentOption == 3) {
						continent = "North America";
					}
					if (continentOption == 4) {
						continent = "Africa";
					}
					if (continentOption == 5) {
						continent = "Oceania";
					}
					if (continentOption == 6) {
						continent = "Antarctica";
					}
					if (continentOption == 7) {
						continent = "South America";
					}
					//Asking the user for the information needed to insert
					String surfacearea = JOptionPane.showInputDialog("Please, enter a valid surface area: ");
					float sufaceAreaFloat = Float.parseFloat(surfacearea);
					String headofstate = JOptionPane.showInputDialog("Please, enter a valid Head Of State: ");
					
					 //new object type Country
					Country country = new Country(code, name, continent, sufaceAreaFloat, headofstate);
					//db.saveCountry(country);
					
					/*
					 * Calling the saveCountry method passing in the parameter an object of type COuntry
					 * with all the information that the user typed to be inserted in the database
					 */
					if (db.saveCountry(country) == false) {// in case return false, show error message
						JOptionPane.showMessageDialog(null,
								"It was not possible insert this country. Please, try it again with valid values.", //the message to the user
						        "Information",  
						        JOptionPane.ERROR_MESSAGE);
					} else {
						//else if the return of the method is true
						// show a success message to the user
						JOptionPane.showMessageDialog(null,
								"The country " + name + " was inserted into the table.", 
						        "Information", 
						        JOptionPane.INFORMATION_MESSAGE);
					}	
						
					
				}else if (arg0.getActionCommand() == "b1") {//B1 é refer to button1 = new JButton("GET ALL COUNTRIES");
					 
					String records = "";
					// Initializing the variable records that will receive the String of all records in the table country with all the details that were located within a Country ARRAYLIST			String records = "";
					for (Country country : db.getCountries()) {
						
						//Connecting the details of the current country of the list into the String records
						records = records + country.toString() + "\n";
					}
					JOptionPane.showMessageDialog(null,
							records, //Here is the msg to be displayed to the user, in this case it will be records, as they are all data from all countries in the database
					        "Information", 
					        JOptionPane.INFORMATION_MESSAGE);
				}
	}

}


