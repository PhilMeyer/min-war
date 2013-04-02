package com.ess.util.mw.resolve;

import com.ess.util.mw.AltUnit;

public interface DamResolveStrategy {

	int resolve(AltUnit a, AltUnit b, int pow);
	
}
