package edu.cleansweep.tests;

import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.FloorType;
import edu.cleansweep.floor.Location;

public class FloorTest {

	public static void main(String[] args)
	{		 	
		FloorNavigationProxy floorNavProxy = new FloorNavigationProxy("TEST_C.cft");
		Location currentLocation = floorNavProxy.getStaringLocation();
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.SOUTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.WEST);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		floorNavProxy = new FloorNavigationProxy("TEST_B.cft");
		//System.out.println(floorNavProxy.toString());
		
		floorNavProxy = new FloorNavigationProxy("TEST_B.cft");
		Location startingLocation = floorNavProxy.getStaringLocation();
		
		currentLocation = startingLocation;
		//are these two locations really equal?
		System.out.println(currentLocation.equals(startingLocation));
		
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.WEST);
		System.out.println(currentLocation.toString());
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		FloorType ft = floorNavProxy.getFloorType(currentLocation);
		System.out.println(ft);
		System.out.println(currentLocation.toString());
		
		while(!currentLocation.isClean())
			floorNavProxy.clean(currentLocation); //removes dirt and prints Removing Dirt Message
		floorNavProxy.clean(currentLocation); //Prints clean message
		
	}
	
	
}
