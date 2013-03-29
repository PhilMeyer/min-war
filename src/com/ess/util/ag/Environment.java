package com.ess.util.ag;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ess.util.mw.Unit;
import com.ess.util.mw.rw.Location;

public class Environment {

	Map<Unit, Location> unitLocations = new HashMap<>();

	public List<UnitDistance> getClosestUnits(Unit u1) {
		Location l = unitLocations.get(u1);
		List<UnitDistance> list = new ArrayList<>();
		for (Entry<Unit, Location> entry : unitLocations.entrySet()) {
			if(entry.getKey().equals(u1)){
				continue;
			}
			double d = GeometryUtil.distance(l, entry.getValue());
			list.add(new UnitDistance(entry.getKey(), d));
		}
		Collections.sort(list);
		//System.out.println(list);
		return list;
	}

	class UnitDistance implements Comparable<UnitDistance>{
		Unit u;
		double d;

		public UnitDistance(Unit u, double d) {
			this.u = u;
			this.d = d;
		}

		@Override
		public int compareTo(UnitDistance o) {
			return Double.valueOf(d).compareTo(o.d);
		}
		
		public String toString(){
			return u+" - "+d;
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Collection<TaskTrackingInfo> tasks = ((TaskRegister) TaskRegister
					.getInstance()).getTasks();
			List<TaskTrackingInfo> list = new ArrayList<TaskTrackingInfo>();
			list.addAll(tasks);
			// Collections.sort(list);
			StringBuilder sb = new StringBuilder();
			sb.append("<html>\n<head>\n<style type='text/css'>\n");
			sb.append("table{	font-size:9pt;	border-collapse: collapse;	font-family: Arial, Helvetica, sans-serif;}\n");
			sb.append("td{ border: 1px rgb(100,100,150) solid; background:rgb(235,245,245);padding: 0.2em;}\n");
			sb.append("th{ border: 1px rgb(100,100,150) solid; padding: 0.2em;}\n");
			sb.append("</style>\n</head>\n");
			sb.append("<body>\n<table border='1' style='font-size:10pt'>\n");
			sb.append("<tr><th>Start</th><th>End</th><th>Description</th><th>Job Message</th><th>Job ID</th><th>Task Status</th><th>Task ID</th></tr>\n");
			for (TaskTrackingInfo t : list) {
				buildLine(sb, t);
			}
			sb.append("</table>\n</body>\n");
			PrintWriter writer = resp.getWriter();
			writer.print(sb.toString());
			writer.flush();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void buildLine(StringBuilder sb, TaskTrackingInfo t) {
		// TODO Auto-generated method stub
	}

	public void place(Unit u, Location location) {
		unitLocations.put(u, location);
	}

}
