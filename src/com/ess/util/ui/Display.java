package com.ess.util.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.ess.util.mw.Unit;
import com.ess.util.mw.rw.Env;
import com.ess.util.mw.rw.Location;

public class Display extends JPanel {

	Env environment;
	Logger log = Logger.getLogger(Display.class);
	private static final String IMAGE_DIR = "C:\\Users\\Phil\\Downloads\\WMH_Vassal421\\";
	Unit selected;

	public Display(final Env environment) {
		this.environment = environment;
		setPreferredSize(new Dimension(500, 500));
		setBackground(Color.GRAY);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(environment, e);
			}

			private void clicked(final Env environment, MouseEvent e) {
				// log.debug("Clicked: "+e);
				Unit u = environment.getUnitAt(e.getX(), e.getY());
				if (u != null) {
					log.debug(u);
					selected = u;
				}
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.DARK_GRAY);
		drawSelected(g);
		for (Entry<Unit, Location> entry : environment.units().entrySet()) {
			int drawX = entry.getValue().intX();
			int drawY = entry.getValue().intY();
			Image sprite = getImage(entry.getKey().imagePath);
			int w = sprite.getWidth(null);
			g.drawImage(sprite, drawX - w / 2, drawY - w / 2, null);
		}
	}

	private void drawSelected(Graphics g) {
		if (selected != null) {
			Location loc = environment.getLocation(selected);
			String auraPath = selected.base + "mm_Aura_Red.png";
			Image aura = getImage(auraPath);
			int w = aura.getWidth(null);
			g.drawImage(aura, loc.intX() - w / 2, loc.intY() - w / 2, null);
		}
	}

	private Image getImage(String auraPath) {
		Image aura = null;
		try {
			aura = ImageIO.read(new File(IMAGE_DIR, auraPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aura;
	}

}
