package com.ess.util.mw.resolve;

import com.ess.util.mw.Unit;

public interface DamResolveStrategy {

	int resolve(Unit a, Unit b, int pow);
	
}
