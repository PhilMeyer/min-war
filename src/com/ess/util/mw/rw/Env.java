package com.ess.util.mw.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.ess.util.mw.Unit;

public class Env {

	Logger log = Logger.getLogger(Env.class);
	Map<Unit,Location> unitLocations = new HashMap<>();

	public void addUnit(Unit u, Location location) {
		unitLocations.put(u, location);
	}
	
	public Map<Unit,Location> units(){
		return unitLocations; // TODO defensive copy
	}

	public Unit getUnitAt(int x, int y) {
		for(Entry<Unit,Location> entry : units().entrySet()){
			double distance = GeometryUtils.distance(new Location(x,y),entry.getValue());
			log.debug(distance);
			if(distance < entry.getKey().getSize()/2){
				return entry.getKey();
			}
		}
		return null;
	}
	
}
