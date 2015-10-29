package edu.cleansweep.controlsystem;

import edu.cleansweep.floor.*;

public class ControlSystem {

	private int currentX;
	private int currentY;
	private DiscoveryMap discoveryMap;
	
	private Decision decision;
	private Location currentLocation;
	private FloorNavigationProxy floorNavProxy;

	public ControlSystem(){
		currentX = 0;
		currentY = 0;
		
		discoveryMap = new DiscoveryMap();
		discoveryMap.addToMap(new NavigationCell(currentX, currentY));
		
		floorNavProxy = new FloorNavigationProxy("TEST_C.cft");
		currentLocation = floorNavProxy.getStaringLocation();
	}

	/**
	 * This test implementation of move randomly moves the current location
	 */
	
	public void move(){
		
		Move move = new Move(floorNavProxy);
		
		decision = new Decision(currentLocation, floorNavProxy, discoveryMap, 
				discoveryMap.get(currentX,  currentY));
		
		currentLocation = move.executeMove(currentLocation, decision.run());
		
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
	}
	
	public static void main(String [] args)
	{
		ControlSystem cs = new ControlSystem();
		
		int i = 0;
		while(i < 15)
		{
			cs.move();
			i++;
		}
	}
}
