package edu.cleansweep.tests;

import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.FloorType;
import edu.cleansweep.floor.Location;

import static org.junit.Assert.*;
import org.junit.Test;

public class FloorTest {

	FloorNavigationProxy floorNavProxy;
	
	@Test
	public void testStartingLocation(){		 	
		
		String [] floorPlanFiles = {"TEST_A.cft", "TEST_B.cft", "TEST_C.cft", "TEST_D.cft", "TEST_E.cft"};
		
		for(int i=0; i<floorPlanFiles.length; i++){
			// should add exception handling in Floor for reading floor plan
			floorNavProxy = new FloorNavigationProxy(floorPlanFiles[i]);
			Location startingLocation = floorNavProxy.getStaringLocation();
			floorNavProxy.displayLocationOnFloorInConsole(startingLocation);
			
			// Is Starting Location Not Null? Shouldn't be
			assertNotNull(startingLocation);
			// Is Starting Location Obstructed?  Shouldn't be
			assertFalse(startingLocation.isObstructed());
			// Is Starting Location a Charging Station?  It Should Be
			assertEquals(floorNavProxy.getFloorType(startingLocation), FloorType.CHARGINGSTATION);
			// Is Starting Location "Clean" It Should be 
			assertTrue(startingLocation.isClean()); 
		}

	}
	
	@Test
	public void testMove(){
		
		String [] floorPlanFiles = {"TEST_A.cft", "TEST_B.cft", "TEST_C.cft", "TEST_D.cft", "TEST_C.cft"};
		
		for(int i=0; i<floorPlanFiles.length; i++){
			
			floorNavProxy = new FloorNavigationProxy(floorPlanFiles[i]);
			Location startingLocation = floorNavProxy.getStaringLocation();
			//floorNavProxy.displayLocationOnFloorInConsole(startingLocation);
			Location movingLocation = startingLocation;
			
			// Assert Moving Location and Starting Location have the same coordinates
			assertEquals(startingLocation.getLatitude(), movingLocation.getLatitude());
			assertEquals(startingLocation.getLongitude(), movingLocation.getLongitude());
			
			// Save previous location
			Location previousLocation = movingLocation;
			
			// Assert Moving Location and Starting Location have the same coordinates
			assertEquals(startingLocation.getLatitude(), previousLocation.getLatitude());
			assertEquals(startingLocation.getLongitude(), previousLocation.getLongitude());
			
			// Assert Transitivity if startLocation = movingLocation and previousLocation = movingLocation
			// then previousLocation = startingLocation
		
			assertEquals(startingLocation, movingLocation);
			assertEquals(startingLocation, previousLocation);
			
			
			for(Direction d : Direction.values()){
			
				// Can Move particular Direction? If No then location must be obstructed
				if(floorNavProxy.canMove(previousLocation, d)){
					
					movingLocation = floorNavProxy.move(previousLocation, d);
					// assert movingLocation is not null
					assertNotNull(movingLocation);
					// assert not an obstruction
					assertNotEquals(FloorType.OBSTACLE, floorNavProxy.getFloorType(movingLocation));
					
					switch(d){
					
					case NORTH:
						// assert Latitude is not equal
						assertNotEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						// assert Latitude is one greater than previous location
						assertEquals(previousLocation.getLatitude() + 1, movingLocation.getLatitude());
						// assert Longitude is the same
						assertEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						// assert moving location and previous location are not the same object
						assertNotEquals(previousLocation, movingLocation);
						
						// TEST MOVE BACK
						movingLocation = floorNavProxy.move(movingLocation, d.getOpposite());
						// assert Moving Location and Previous Location are now equal
						assertEquals(previousLocation,movingLocation);
						// assert not obstructed
						assertFalse(movingLocation.isObstructed());
						// assert Latitude and Longitude now the same as previous location
						assertEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						assertEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						break;
					
					case NORTHEAST:
						// assert Latitude is not equal
						assertNotEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						// assert Latitude is one greater than previous location
						assertEquals(previousLocation.getLatitude() + 1, movingLocation.getLatitude());
						// assert Longitude is not equal
						assertNotEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						// assert Longitude is one greater than previous location
						assertEquals(previousLocation.getLongitude()+1, movingLocation.getLongitude());
						// assert moving location and previous location are not the same object
						assertNotEquals(previousLocation, movingLocation);
						
						// TEST MOVE BACK
						movingLocation = floorNavProxy.move(movingLocation, d.getOpposite());
						// assert Moving Location and Previous Location are now equal
						assertEquals(previousLocation,movingLocation);
						// assert not obstructed
						assertFalse(movingLocation.isObstructed());
						// assert Latitude and Longitude now the same as previous location
						assertEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						assertEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						break;

						
					case EAST:
						// assert Latitude is equal
						assertEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						// assert Longitude not equal
						assertNotEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						// assert Longitude is one more than previous location
						assertEquals(previousLocation.getLongitude()+1, movingLocation.getLongitude());
						// assert moving location and previous location are not the same object
						assertNotEquals(previousLocation, movingLocation);
						
						// TEST MOVE BACK
						movingLocation = floorNavProxy.move(movingLocation, d.getOpposite());
						// assert Moving Location and Previous Location are now equal
						assertEquals(previousLocation,movingLocation);
						// assert not obstructed
						assertFalse(movingLocation.isObstructed());
						// assert Latitude and Longitude now the same as previous location
						assertEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						assertEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						break;

					
					case SOUTHEAST:
						// assert Latitude is not equal
						assertNotEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						// assert Latitude is one greater than previous location
						assertEquals(previousLocation.getLatitude() - 1, movingLocation.getLatitude());
						// assert Longitude is not equal
						assertNotEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						// assert Longitude is one greater than previous location
						assertEquals(previousLocation.getLongitude()+1, movingLocation.getLongitude());
						// assert moving location and previous location are not the same object
						assertNotEquals(previousLocation, movingLocation);
						break;
						
					case SOUTH:
						// assert Latitude is not equal
						assertNotEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						// assert Latitude is one greater than previous location
						assertEquals(previousLocation.getLatitude() - 1, movingLocation.getLatitude());
						// assert Longitude is the same
						assertEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						// assert moving location and previous location are not the same object
						assertNotEquals(previousLocation, movingLocation);

						// TEST MOVE BACK
						movingLocation = floorNavProxy.move(movingLocation, d.getOpposite());
						// assert Moving Location and Previous Location are now equal
						assertEquals(previousLocation,movingLocation);
						// assert not obstructed
						assertFalse(movingLocation.isObstructed());
						// assert Latitude and Longitude now the same as previous location
						assertEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						assertEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						break;

					
					case SOUTHWEST:
						// assert Latitude is not equal
						assertNotEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						// assert Latitude is one greater than previous location
						assertEquals(previousLocation.getLatitude() - 1, movingLocation.getLatitude());
						assertNotEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						// assert Longitude is one more than previous location
						assertEquals(previousLocation.getLongitude()-1, movingLocation.getLongitude());
						// assert moving location and previous location are not the same object
						assertNotEquals(previousLocation, movingLocation);

						// TEST MOVE BACK
						movingLocation = floorNavProxy.move(movingLocation, d.getOpposite());
						// assert Moving Location and Previous Location are now equal
						assertEquals(previousLocation,movingLocation);
						// assert not obstructed
						assertFalse(movingLocation.isObstructed());
						// assert Latitude and Longitude now the same as previous location
						assertEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						assertEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						break;

						
					case WEST:
						// assert Latitude is equal
						assertEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						// assert Longitude not equal
						assertNotEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						// assert Longitude is one more than previous location
						assertEquals(previousLocation.getLongitude()-1, movingLocation.getLongitude());
						// assert moving location and previous location are not the same object
						assertNotEquals(previousLocation, movingLocation);

						// TEST MOVE BACK
						movingLocation = floorNavProxy.move(movingLocation, d.getOpposite());
						// assert Moving Location and Previous Location are now equal
						assertEquals(previousLocation,movingLocation);
						// assert not obstructed
						assertFalse(movingLocation.isObstructed());
						// assert Latitude and Longitude now the same as previous location
						assertEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						assertEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						break;

					
					case NORTHWEST:
						// assert Latitude is not equal
						assertNotEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						// assert Latitude is one greater than previous location
						assertEquals(previousLocation.getLatitude() + 1, movingLocation.getLatitude());
						assertNotEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						// assert Longitude is one more than previous location
						assertEquals(previousLocation.getLongitude()-1, movingLocation.getLongitude());
						// assert moving location and previous location are not the same object
						assertNotEquals(previousLocation, movingLocation);

						// TEST MOVE BACK
						movingLocation = floorNavProxy.move(movingLocation, d.getOpposite());
						// assert Moving Location and Previous Location are now equal
						assertEquals(previousLocation,movingLocation);
						// assert not obstructed
						assertFalse(movingLocation.isObstructed());
						// assert Latitude and Longitude now the same as previous location
						assertEquals(previousLocation.getLatitude(), movingLocation.getLatitude());
						assertEquals(previousLocation.getLongitude(), movingLocation.getLongitude());
						break;
					}
					
					
				}
				else{
					Location obstructedLocation = floorNavProxy.move(previousLocation, d);
					// Assert Cell Obstructed
					assertTrue(obstructedLocation.isObstructed());
					// Assert Cell isn't dirty
					assertTrue(obstructedLocation.isClean());
					// Assert Cell FloorType is FloorType.OBSTACLE
					assertEquals(FloorType.OBSTACLE, floorNavProxy.getFloorType(obstructedLocation));
					// Assert previousLocation and obstructed location are not the same object
					assertNotEquals(previousLocation, obstructedLocation);
				}
			}
			
		}
		
	}
	
	@Test
	public void testTraversePathFileC(){
		
		floorNavProxy = new FloorNavigationProxy("TEST_C.cft");
		Location currentLocation = floorNavProxy.getStaringLocation();
		
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		for(int i=0; i<5; i++){
			if(floorNavProxy.canMove(currentLocation, Direction.NORTH)){
				currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
				
				// assert not null
				assertNotNull(currentLocation);
				// assert not obstacle
				assertNotEquals(FloorType.OBSTACLE, floorNavProxy.getFloorType(currentLocation));
				// assert not obstructed
				assertFalse(currentLocation.isObstructed());
				
				floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
			}
		}
		
		for(int i=0; i<3; i++){
			
			if(floorNavProxy.canMove(currentLocation, Direction.WEST)){
				currentLocation = floorNavProxy.move(currentLocation, Direction.WEST);
				
				// assert not null
				assertNotNull(currentLocation);
				// assert not obstacle
				assertNotEquals(FloorType.OBSTACLE, floorNavProxy.getFloorType(currentLocation));
				// assert not obstructed
				assertFalse(currentLocation.isObstructed());
				
				floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
			}
			
		}
	
		// assert can't move North
		assertFalse(floorNavProxy.canMove(currentLocation, Direction.NORTH));
		// assert can't move West
		assertFalse(floorNavProxy.canMove(currentLocation, Direction.WEST));
		// assert can move south
		assertTrue(floorNavProxy.canMove(currentLocation, Direction.SOUTH));
		// Move South
		currentLocation = floorNavProxy.move(currentLocation, Direction.SOUTH);
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		// assert not null, not obstacle, not obstructed
		assertNotNull(currentLocation);
		assertNotEquals(FloorType.OBSTACLE, floorNavProxy.getFloorType(currentLocation));
		assertFalse(currentLocation.isObstructed());
		// assert high pile carpet
		assertEquals(FloorType.HIGHPILECARPET, floorNavProxy.getFloorType(currentLocation));
	}
		/*currentLocation = floorNavProxy.move(currentLocation, Direction.SOUTH);
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
		*/
		

	
}
