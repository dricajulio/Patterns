package patterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener{

	/*
	 * Each instance of this class will have a 
	 * reference to the singleton writer object
	 */
	SingletonWritter sw = SingletonWritter.getInstance();
	
	//@Override
	public void actionPerformerd (ActionEvent arg0) {
		// building the string that is going to be printed to the console
		//String log = "Button " + arg0.getActionCommand() + " pressed. " + new Date() +"\n";
		// Using the singleton writer
		//sw.writeToFile(log);
			
		// Condition for each different feature depending on which button that was pressed
		if (arg0.getActionCommand() == "b2") {//B2 refer to button2 = new JButton("GET BY CODE");
			// asking a user to enter a code
			String code = JOptionPane.showInputDialog ("Please enter a valid code: ");
			// Using the singleton writer to access the database and generate information
			sw.GetCountryCode(code);
			
		} else if (arg0.getActionCommand() == "b3") {//B3 refer to button3 = new JButton("GET BY NAME");
			// asking user to enter a name	
			String name = JOptionPane.showInputDialog ("Please enter a valid name: ");
			// Using the singleton writer to access the database e get information according with the name
						sw.GetCountryName(name);
		
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
				// Condition that performs the validation, as it is only valid if the num of the continent is between 1 and 7				if (continentOption < 1 | continentOption > 7) {
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
			
			// Using the singleton writer to access the database an insert 
			// the information that the user had typed
			sw.InsertNewCountry(code, name, continent, sufaceAreaFloat, headofstate);
			
		}else if (arg0.getActionCommand() == "b1") {//B1 refer to the button1 = new JButton("GET ALL COUNTRIES");
			// If you do not enter any of the conditions, it means that the selected button was the 
			sw.GetAllRecords();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
