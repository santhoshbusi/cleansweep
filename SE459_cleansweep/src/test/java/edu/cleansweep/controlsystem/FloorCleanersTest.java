package edu.cleansweep.controlsystem;

import static org.junit.Assert.*;
import edu.cleansweep.floor.FloorType;

import org.junit.AfterClass;
import org.junit.Test;

public class FloorCleanersTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void getSetBareFloor() {
		
		FloorCleaners floorCleaners = new FloorCleaners();
		floorCleaners.set_floorType(FloorType.BAREFLOOR);
		assertEquals(floorCleaners.get_floorType(),FloorType.BAREFLOOR);
	}
	
	@Test
	public void getSetLowPile() {
		
		FloorCleaners floorCleaners = new FloorCleaners();
		floorCleaners.set_floorType(FloorType.LOWPILECARPET);
		assertEquals(floorCleaners.get_floorType(),FloorType.LOWPILECARPET);
	}
	
	@Test
	public void getSetHighPile() {
		
		FloorCleaners floorCleaners = new FloorCleaners();
		floorCleaners.set_floorType(FloorType.HIGHPILECARPET);
		assertEquals(floorCleaners.get_floorType(),FloorType.HIGHPILECARPET);
	}
}
