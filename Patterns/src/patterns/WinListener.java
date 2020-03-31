package patterns;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WinListener implements WindowListener{

	// Each instance of this class will have a 
	// a reference to the singleton writer object
	SingletonWritter sw = SingletonWritter.getInstance ();
	
	
@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// Using the singleton writer object
		sw.DisconnectDatabase();
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		// Using the singleton writer
		sw.ConnectToDatabase();
	}

}