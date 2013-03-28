package com.ess.util.ui;

import com.ess.util.mw.Unit;
import com.ess.util.mw.UnitFactory;
import com.ess.util.mw.rw.Env;
import com.ess.util.mw.rw.Location;

public class Main {

	public static void main(String[] args) {
		Env e = new Env();
		Unit u = UnitFactory.psm();
		e.addUnit(u , new Location(200,300));
		Frame frame = new Frame(e);
	}
	
}
