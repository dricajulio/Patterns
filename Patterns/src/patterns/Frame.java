package patterns;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel lbMenu;
	
	public Frame() {
		
		
		//Creating Buttons
		button1 = new JButton ("All Countries");
		button2 = new JButton ("By Code");
		button3 = new JButton ("By name");
		lbMenu = new JLabel ("Please, choose an option to get the records: ");
	
		//Creating the panel that will be added to the Frame
		JPanel mainPanel = new JPanel ();
	
		//Adding each button to the panel
		mainPanel.add(lbMenu);
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);
	}

}
