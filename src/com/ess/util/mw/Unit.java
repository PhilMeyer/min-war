package com.ess.util.mw;

import java.util.ArrayList;
import java.util.List;

public class Unit {

	public final int str, def, arm, rat, mat, spd, cmd;
	int hp = 1;
	public final int base;
	String name;
	
	List<Ability> abilities = new ArrayList<>();
	List<Wep> weapons = new ArrayList<>();
	public final String imagePath;

	public Unit(String imagePath, int base, int spd, int str, int mat, int rat, int def, int arm, int cmd){
		this.spd = spd;
		this.str = str;
		this.mat = mat;
		this.rat = rat;
		this.def = def;
		this.arm = arm;
		this.cmd = cmd;
		this.imagePath = imagePath;
		this.base = base;
	}
	
	public int getDefaultWepPow(){
		Wep weapon = weapons.get(0);
		int pow = 0;
		if(weapon != null){
			pow = weapon.pow;
		}
		return pow;
	}

	public void addWep(Wep weapon) {
		weapons.add(weapon);
	}
	
	public String toString(){
		return name+"-"+imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
