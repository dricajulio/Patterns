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
	SingletonWritter sw = SingletonWritter.getInstace();
	
	//@Override
	public void actionPerformerd (ActionEvent arg0) {
		
		String log = "Button " +arg0.getActionCommand() + " pressed. " + new Date () + "\n";
	
		if (arg0.getActionCommand() == "b2") {
			String code = JOptionPane.showInputDialog ("Please enter a valid code: ");
			} else if (arg0.getActionCommand() == "b3") {
				String name = JOptionPane.showInputDialog ("Please enter a valid name: ");
			}else {
				
			}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String log = "Button" + arg0.getActionCommand() + "pressed. " + new Date () +"\n";
		
		if (arg0.getActionCommand() =="b2") {
			String code = JOptionPane.showInputDialog("Please, enter a valid code: ");
		}else if (argo)
		}
	}
}
