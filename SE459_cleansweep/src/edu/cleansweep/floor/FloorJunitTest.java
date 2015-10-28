package edu.cleansweep.floor;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class FloorJunitTest {

 
	
	Floor f = new Floor();

	@Before
	public void setUp() throws Exception {
		f.createDefaultFloorPlan();
	}
	
	
	@Test
	public void testFloor() {
			
		f.createDefaultFloorPlan();
		assertNotNull(f);		
				
		f.placeBareFloorCellAt(5, 9);
		assertEquals("Bare Floor",f.getCellAt(5, 9).getFloorType().toString());
		assertFalse(f.getCellAt(5, 9).isClean());
		
		f.placeDoorCellAt(9, 8);
		assertEquals("Door",f.getCellAt(9, 8).getFloorType().toString());
		assertFalse(f.getCellAt(9, 8).isObstructed());

		assertFalse(f.queryCellAt(16, 17).isEmpty());
		assertEquals("Obstacle",f.getCellAt(16, 17).getFloorType().toString());

		assertEquals("W",f.getCellAt(0, 7).getAdjacentCell(Direction.NORTH).toString());

		assertEquals("B",f.getCellAt(0, 7).getAdjacentCell(Direction.NORTHEAST).toString());
	
		System.out.println(f.toString());
		System.out.println(f.queryCellAt(0,7));
		System.out.println(f.markCellAt(0,7));
		System.out.println(f.visitAllCells());

	
	}

}
