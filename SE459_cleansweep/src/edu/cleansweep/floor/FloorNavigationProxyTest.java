package edu.cleansweep.floor;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class FloorNavigationProxyTest {
		
	@Test
	public void testStaringLocation() {
		Floor fl = new Floor();		
		fl.createDefaultFloorPlan();
		FloorNavigationProxy pxy = new FloorNavigationProxy(fl);	
		
		assertEquals("North",pxy.getStaringLocation().getDirectionHeading().toString());
		assertEquals(1,pxy.getStaringLocation().getLongitude());
		assertEquals(1,pxy.getStaringLocation().getLatitude());
		assertTrue(pxy.getStaringLocation().isClean());
		assertFalse(pxy.getStaringLocation().isObstructed());
	
	}

	@Test
	public void testCanMove() {

		Floor fl = new Floor();		
		
		fl.createDefaultFloorPlan();
		FloorNavigationProxy pxy = new FloorNavigationProxy(fl);
		
		Location location = new Location(fl.getCellAt(0, 7),Direction.NORTHEAST);

		System.out.println(fl.queryCellAt(0, 7));

		assertTrue(pxy.canMove(location, Direction.NORTHEAST));
		assertFalse(pxy.canMove(location, Direction.NORTH));
		assertFalse(pxy.canMove(location, Direction.SOUTH));
		assertTrue(pxy.canMove(location, Direction.SOUTHEAST));
		
		if (pxy.canMove(location, Direction.NORTHEAST)){
			pxy.move(location, Direction.NORTHEAST);
		}
				
		if (pxy.canMove(location, Direction.NORTH)){
			pxy.move(location, Direction.NORTH);
		}
				
		if (pxy.canMove(location, Direction.SOUTH)){
			pxy.move(location, Direction.SOUTH);
		}


	
		Location location2 = new Location(fl.getCellAt(3, 8),Direction.NORTHEAST);
		
		System.out.println(fl.queryCellAt(3, 8));
		
		assertFalse(pxy.canMove(location2, Direction.NORTHEAST));
		assertFalse(pxy.canMove(location2, Direction.NORTH));
		assertTrue(pxy.canMove(location2, Direction.EAST));
		assertTrue(pxy.canMove(location2, Direction.WEST));
		
		if (pxy.canMove(location2, Direction.NORTHEAST)){
			pxy.move(location2, Direction.NORTHEAST);
		}
				
		if (pxy.canMove(location2, Direction.EAST)){
			pxy.move(location2, Direction.EAST);
		}
				
		if (pxy.canMove(location2, Direction.WEST)){
			pxy.move(location2, Direction.WEST);
		}

	
	}

}
