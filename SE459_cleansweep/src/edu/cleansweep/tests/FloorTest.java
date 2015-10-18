package edu.cleansweep.tests;

import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.Floor;
import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.Location;

public class FloorTest {

	public static void main(String[] args)
	{		 
		Floor f = new Floor();
		f.createDefaultFloorPlan();
		System.out.println(f.toString());
		
		System.out.println(f.queryCellAt(0,7));
		System.out.println(f.markCellAt(0,7));
		System.out.println(f.visitAllCells());
		
		FloorNavigationProxy floorNavProxy = new FloorNavigationProxy(f);
		Location currentLocation = floorNavProxy.getStaringLocation();
		
		System.out.println(currentLocation.toString());
		currentLocation = floorNavProxy.move(currentLocation, Direction.WEST);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation,Direction.NORTH);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.EAST);
		System.out.println(currentLocation.toString());
		
		System.out.println(currentLocation.getDirt());
		System.out.println(currentLocation.getDirt());
		System.out.println(currentLocation.getDirt());
		System.out.println(currentLocation.getDirt());
		
		Location alternateLocation = floorNavProxy.getStaringLocation();
		System.out.println(alternateLocation);
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.EAST);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.EAST);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.EAST);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.EAST);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.EAST);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.EAST);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.SOUTH);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.SOUTH);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.SOUTH);
		System.out.println(currentLocation.toString());
		
		currentLocation = floorNavProxy.move(currentLocation, Direction.SOUTH);
		System.out.println(currentLocation.toString());
	}
	
	
}
