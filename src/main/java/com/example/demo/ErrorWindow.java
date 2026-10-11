package com.example.demo;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorWindow {
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Please use a valid input");
	
	ErrorWindow(){
		label.setBounds(0,0,500,50);
		label.setFont(new Font(null,Font.PLAIN,25));
		frame.add(label);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
