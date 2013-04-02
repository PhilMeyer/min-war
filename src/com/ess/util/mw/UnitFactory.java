package com.ess.util.mw;

public class UnitFactory {


	public static Unit forgeGuard(){
		Unit unit = new Unit("M_U_ForgeGuard.png", 30, 6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static Unit driller(){
		Unit unit = new Unit("M_J_Driller.png", 50, 6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static Unit gunner(){
		Unit unit = new Unit("M_J_Gunner.png", 40, 6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static Unit blaster(){
		Unit unit = new Unit("M_J_Blaster.png", 40, 6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static Unit thor(){
		Unit unit = new Unit("M_S_Thor.png", 30, 6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static Unit gordson(){
		Unit unit = new Unit("M_W_Gorten.png", 30,6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static Unit forgeGuard(String name) {
		Unit u = forgeGuard();
		u.setName(name);
		return u;
	}
	
}
