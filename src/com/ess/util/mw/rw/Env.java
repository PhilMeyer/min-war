package com.ess.util.mw.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.ess.util.mw.AltUnit;

public class Env {

	Logger log = Logger.getLogger(Env.class);
	Map<AltUnit,Location> unitLocations = new HashMap<>();

	public void addUnit(AltUnit u, double x, double y) {
		addUnit(u, new Location(x, y));
	}
	
	
	public void addUnit(AltUnit u, Location location) {
		unitLocations.put(u, location);
	}
	
	public Map<AltUnit,Location> units(){
		return unitLocations; // TODO defensive copy
	}

	public AltUnit getUnitAt(int x, int y) {
		for(Entry<AltUnit,Location> entry : units().entrySet()){
			double distance = GeometryUtils.distance(new Location(x,y),entry.getValue());
			//log.debug(distance);
			if(distance < entry.getKey().base/2){
				return entry.getKey();
			}
		}
		return null;
	}


	public Location getLocation(AltUnit selected) {
		return unitLocations.get(selected);
	}
	
}
