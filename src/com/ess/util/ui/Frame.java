package com.ess.util.ui;

import javax.swing.JFrame;

import com.ess.util.mw.rw.Env;

public class Frame extends JFrame{

	Display display;
	
	public Frame(Env e){
		super("Hate this part");
		display = new Display(e);
		assemble();
		pack();
		setLocation(500,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void assemble() {
		getContentPane().add(display);
	}
	
	
}
