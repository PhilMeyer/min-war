package com.ess.util.ui;

import com.ess.util.mw.AltUnit;
import com.ess.util.mw.UnitFactory;
import com.ess.util.mw.rw.Env;
import com.ess.util.mw.rw.Location;

public class Main {

	public static void main(String[] args) {
		Env e = new Env();


		e.addUnit(UnitFactory.thor(), 100, 330);
		e.addUnit(UnitFactory.gunner(), 40, 300);

		int startFG = 140;
		e.addUnit(UnitFactory.forgeGuard(), startFG, 300);
		e.addUnit(UnitFactory.forgeGuard(), startFG+60, 300);
		e.addUnit(UnitFactory.forgeGuard(), startFG+120, 300);
		e.addUnit(UnitFactory.forgeGuard(), startFG+30, 330);
		e.addUnit(UnitFactory.forgeGuard(), startFG+90, 330);
		e.addUnit(UnitFactory.forgeGuard(), startFG+60, 360);
		
		//e.addUnit(UnitFactory.forgeGuard(), startFG+60, 300);
		//e.addUnit(UnitFactory.forgeGuard(), startFG+30, 325);
		//e.addUnit(UnitFactory.forgeGuard(), startFG+70, 325);
		//e.addUnit(UnitFactory.forgeGuard(), startFG+120, 300);
		//e.addUnit(UnitFactory.forgeGuard(), startFG+60, 350);
		//e.addUnit(UnitFactory.blaster(), startFG+160, 300);

		e.addUnit(UnitFactory.gordson(), 360, 360);
		e.addUnit(UnitFactory.driller(),410, 300);
		e.addUnit(UnitFactory.gunner(), 480, 350);
		e.addUnit(UnitFactory.blaster(), 320, 300);
		Frame frame = new Frame(e);
	}

}
