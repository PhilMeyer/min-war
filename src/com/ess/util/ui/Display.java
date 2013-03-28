package com.ess.util.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map.Entry;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.ess.util.mw.Unit;
import com.ess.util.mw.rw.Env;
import com.ess.util.mw.rw.Location;

public class Display extends JPanel{

	Env environment;
	Logger log = Logger.getLogger(Display.class);
	
	public Display(final Env environment){
		this.environment = environment;
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.GRAY);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				//log.debug("Clicked: "+e);
				Unit u = environment.getUnitAt(e.getX(),e.getY());
				if(u != null){
					log.debug(u);
				}
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.DARK_GRAY);
		for(Entry<Unit,Location> entry : environment.units().entrySet()){
			int r = entry.getKey().getSize() / 2;
			int drawX = entry.getValue().intX();
			int drawY = entry.getValue().intY();
			//g.fillOval(drawX, drawY, size, size);
			g.fillOval(drawX-r, drawY-r, 2*r, 2*r);
			
		}
	}
	
	
}
