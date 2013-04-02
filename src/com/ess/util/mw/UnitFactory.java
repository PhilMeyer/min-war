package com.ess.util.mw;

public class UnitFactory {


	public static AltUnit forgeGuard(){
		AltUnit unit = new AltUnit("M_U_ForgeGuard.png", 30, 6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static AltUnit driller(){
		AltUnit unit = new AltUnit("M_J_Driller.png", 50, 6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static AltUnit gunner(){
		AltUnit unit = new AltUnit("M_J_Gunner.png", 40, 6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static AltUnit blaster(){
		AltUnit unit = new AltUnit("M_J_Blaster.png", 40, 6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static AltUnit thor(){
		AltUnit unit = new AltUnit("M_S_Thor.png", 30, 6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static AltUnit gordson(){
		AltUnit unit = new AltUnit("M_W_Gorten.png", 30,6,6,6,6,13,13,7);
		unit.addWep(new Wep(3));
		return unit;
	}

	public static AltUnit forgeGuard(String name) {
		AltUnit u = forgeGuard();
		u.setName(name);
		return u;
	}
	
}
