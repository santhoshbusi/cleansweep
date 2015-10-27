package edu.cleansweep.controlsystem;

import edu.cleansweep.floor.*;

public class ControlSystem {

	Location currentLocation;
	FloorNavigationProxy floorNavProxy;

	public ControlSystem(){
		floorNavProxy = new FloorNavigationProxy("TEST_C.cft");
		currentLocation = floorNavProxy.getStaringLocation();
	}

	/**
	 * This test implementation of move randomly moves the current location
	 */
	public void move(){
		Move move = new Move(floorNavProxy);
		int random = (int)(Math.random() * (4 - 0) + 1);
		switch(random)
		{
			case 1:
				if(floorNavProxy.canMove(currentLocation, Direction.NORTH)){
					currentLocation = move.executeMove(currentLocation, Direction.NORTH);
					floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
				}
			break;
			
			case 2:
				if(floorNavProxy.canMove(currentLocation, Direction.SOUTH)){
					currentLocation = move.executeMove(currentLocation, Direction.SOUTH);
					floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
				}
			break;
			
			case 3:
				if (floorNavProxy.canMove(currentLocation, Direction.WEST)){
					currentLocation = move.executeMove(currentLocation, Direction.WEST);
					floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
				}
			break;
			
			case 4:
				 if (floorNavProxy.canMove(currentLocation, Direction.EAST)){
					 currentLocation = move.executeMove(currentLocation, Direction.EAST);
					 floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
			}
			break;
		}
	}
	
	public static void main(String [] args)
	{
		ControlSystem cs = new ControlSystem();
		
		int i = 0;
		while(i < 10)
		{
			cs.move();
			i++;
		}
	}
}
