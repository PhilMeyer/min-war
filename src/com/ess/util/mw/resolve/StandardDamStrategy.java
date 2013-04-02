package com.ess.util.mw.resolve;

import com.ess.util.mw.AltUnit;

public class StandardDamStrategy implements DamResolveStrategy {

	@Override
	public int resolve(AltUnit a, AltUnit d, int pow) {
		int damRoll = Sim.d2.roll();
		int ps = pow + a.str;
		int calcDam = ps + damRoll - d.arm;
		if(calcDam < 0){
			calcDam = 0;
		}
		Sim.log("P+S[{0}] vs ARM[{1}]:  {2}(2d6) + {0} - {1} = {3}", ps, d.arm, damRoll, calcDam);
		return calcDam;
	}

}
