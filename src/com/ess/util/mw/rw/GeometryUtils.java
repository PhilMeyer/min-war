package com.ess.util.mw.rw;

public class GeometryUtils {

	public static double distance(Location l1, Location l2) {
		return Math.sqrt(Math.pow(l1.x - l2.x, 2) + Math.pow(l1.y - l2.y, 2) );
	}
	
	public static void main(String[] args) {
		System.out.println(distance(new Location(1,1), new Location(5, 5)));
	}

}
