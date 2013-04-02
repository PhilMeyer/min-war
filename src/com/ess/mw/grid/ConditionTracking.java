package com.ess.mw.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ess.util.mw.AltUnit;

public class ConditionTracking {

	Map<AltUnit,List<Condition>> map = new HashMap<>();
	
	public void addCondition(AltUnit unit, ConditionType type, int rounds){
		if(!map.containsKey(unit)){
			map.put(unit, new ArrayList<Condition>());
		}
		List<Condition> list = map.get(unit);
		list.add(new Condition(type,rounds));
	}
	
	public void decrement(){
		for(Entry<AltUnit,List<Condition>> entry : map.entrySet()){
			List<Condition> list = entry.getValue();
			Iterator<Condition> iterator = list.iterator();
			while(iterator.hasNext()){
				Condition c = iterator.next();
				c.rounds--;
				if(c.rounds < 1){
					list.remove(c);
				}
			}
		}
	}
	
}
