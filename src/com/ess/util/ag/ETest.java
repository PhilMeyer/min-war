package com.ess.util.ag;

import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import com.ess.util.ag.Environment.UnitDistance;
import com.ess.util.mw.AltUnit;
import com.ess.util.mw.UnitFactory;
import com.ess.util.mw.rw.Location;

public class ETest extends TestCase{

	Environment e = new Environment();

	AltUnit ref = UnitFactory.forgeGuard();
	
	@Override		
	public void setUp(){
		e.place(ref,new Location(0,0));
		Random r = new Random();
		for(int i = 0; i < 100000; i++){
			e.place(UnitFactory.forgeGuard(),new Location(r.nextInt(100000),r.nextInt(100000)));
		}
	}
	
	
	public void testGetClosest(){
		List<UnitDistance> closestUnits = e.getClosestUnits(ref);
		System.out.println(closestUnits.get(0));
		System.out.println(closestUnits.get(closestUnits.size()-1));
		
	}
	
}
