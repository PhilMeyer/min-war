package com.ess.util.ag;

import com.ess.util.mw.AltUnit;
import com.ess.util.mw.rw.Location;

public class ColAvoid {

	Environment e;
	
	public ColAvoid(Environment e){
		this.e = e;
	}
	
	public void swing(Location loc, double dist){
		for(int i = 0; i < 360; i++){
			Location point = GeometryUtil.getPointWithAngleAndRadius(loc, i, dist);
			System.out.println(point);
		}
	}
	
	public Location getWorkable(AltUnit u1, AltUnit u2, double range){
		Location l1 = e.unitLocations.get(u1);
		Location l2 = e.unitLocations.get(u2);
		Location ideal = getIdeal(l1, l2, u1.base, u2.base, range);
		AltUnit collision = e.isCollision(u1, ideal);
		if(collision == null){
			//System.out.println("Ideal was free: "+ideal);
			return ideal;
		}
		//System.out.println("Ideal was occupied: "+ideal);
		
		int offset = 1;
		double idealDist = range + u1.base/2 + u2.base/2;
		int angle = GeometryUtil.getAngle(l2, l1);
		while(offset < 360){
			//System.out.println("Offset="+offset);
			int la = angle-offset;
			int ra = angle+offset;
			Location left = GeometryUtil.getPointWithAngleAndRadius(l2, la, idealDist);
			Location right = GeometryUtil.getPointWithAngleAndRadius(l2, ra, idealDist);
			//System.out.println("L angle = "+la);
			//System.out.println("R angle = "+ra);
			//System.out.println("Ideal Dist=("+idealDist+") L="+left+ " R="+right);
			AltUnit lCol = e.isCollision(u1, left);
			AltUnit rCol = e.isCollision(u2, right);
			if(lCol == null){
				//System.out.println("Left is free!");
				return left;
			}
			if(rCol == null){
				//System.out.println("Right is free!");
				return right;
			}
			//System.out.println("Both occupied.");
			offset++;			
		}
		return null;
	}
	
	
	public Location getIdeal(Location start, Location goal, int tSize, int uSize, double range){
		double idealDist = range + tSize/2 + uSize/2;
		double dX = goal.x - start.x;
		double dY = goal.y - start.y;
		double dist = GeometryUtil.distance(start, goal);
		double ratio = idealDist/dist;
		double newX = goal.x - dX*ratio;
		double newY = goal.y - dY*ratio;
		return new Location(newX, newY);
	}
	
	public static void main(String[] args) {
		ColAvoid c = new ColAvoid(null);
		Location goal = new Location(100,100);
		Location best = c.getIdeal(new Location(0,0), goal, 30, 30, 15);
		System.out.println(best);
		System.out.println(GeometryUtil.distance(goal, best));
	}
	
	
}
