package com.ess.util.mw;

public class UnitFactory {

	public static Unit psm(){
		Unit unit = new Unit(6,6,6,6,13,13,7);
		unit.addWep(new W(3));
		return unit;
	}
	
	
}
