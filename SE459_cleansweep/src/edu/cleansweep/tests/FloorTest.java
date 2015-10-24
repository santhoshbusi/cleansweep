package edu.cleansweep.tests;

import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.Floor;
import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.FloorType;
import edu.cleansweep.floor.Location;

public class FloorTest {

	public static void main(String[] args)
	{		 
		Floor f = new Floor();
		
		f.createFloorPlanFromFile("TEST_C.cft");
		System.out.println(f.toString());
		
		FloorNavigationProxy floorNavProxy = new FloorNavigationProxy("TEST_C.cft");
		Location currentLocation = floorNavProxy.getStaringLocation();
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.SOUTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.WEST);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		f.createFloorPlanFromFile("TEST_B.cft");
		System.out.println(f.toString());
		
		floorNavProxy = new FloorNavigationProxy("TEST_B.cft");
		currentLocation = floorNavProxy.getStaringLocation();
		
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.WEST);
		System.out.println(currentLocation.toString());
		f.displayLocationOnFloorInConsole(currentLocation);
		
		FloorType ft = floorNavProxy.getFloorType(currentLocation);
		System.out.println(ft);
		System.out.println(currentLocation.toString());
		
		while(!currentLocation.isClean())
			floorNavProxy.clean(currentLocation); //removes dirt and prints Removing Dirt Message
		floorNavProxy.clean(currentLocation); //Prints clean message
	}
	
	
}
