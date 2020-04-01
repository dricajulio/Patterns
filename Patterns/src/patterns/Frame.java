package patterns;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	// All four buttons of the window
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JLabel lbMenu;
	
	
	public Frame() {
		
		// Creating Buttons
		button1 = new JButton("GET ALL COUNTRIES");
		button2 = new JButton("GET BY CODE");
		button3 = new JButton("GET BY NAME");
		button4 = new JButton("INSERT NEW COUNTRY");
		lbMenu = new JLabel("Please, choose an option:                                 ");
		
		//Creating the panel that will be added to the frame
		JPanel mainPanel = new JPanel();
		
		//Adding each button to the panel
		mainPanel.add(lbMenu);
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);
		mainPanel.add(button4);
		
		// Identifying each one of the buttons
		button1.setActionCommand("b1");
		button2.setActionCommand("b2");
		button3.setActionCommand("b3");
		button4.setActionCommand("b4");
		
		// creating four different
		// instances of the ButtonListener class. This way
		// each button has its own action listener
		button1.addActionListener(new ButtonListener());
		button2.addActionListener(new ButtonListener());
		button3.addActionListener(new ButtonListener());
		button4.addActionListener(new ButtonListener());
		
		// Creating an instance of the Window Listener
		this.addWindowListener(new WinListener());
		
		this.add(mainPanel);
		
		this.setTitle("Adriana Moreira- World  System"); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setSize(400,200);
		this.validate();
		this.repaint();
	}


}
