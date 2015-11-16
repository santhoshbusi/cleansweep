package edu.cleansweep.controlsystem;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class ControlSystemTest {

	@Test
	public void StartingLocationTest() {
		
		ControlSystem cs = new ControlSystem("TEST_A.cft");
		assertNotNull(cs);
		assertEquals(cs.getCurrentX(), 0);
		assertEquals(cs.getCurrentY(), 0);
	}
	
	@Test
	public void FloorFileTest() {
		
		ControlSystem cs = new ControlSystem("TEST_A.cft");
		
		assertNotNull(cs);
	}
	
	@Test
	public void CompletionTest() {
		
		ControlSystem cs = new ControlSystem("TEST_A.cft");
		cs.start();
		assertTrue((cs.getEmptyMeLight()) || cs.countPotentiallyDirtyCells() == 0);
		
		cs = new ControlSystem("TEST_B.cft");
		cs.start();
		assertTrue((cs.getEmptyMeLight()) || cs.countPotentiallyDirtyCells() == 0);
		
		cs = new ControlSystem("TEST_C.cft");
		cs.start();
		assertTrue((cs.getEmptyMeLight()) || cs.countPotentiallyDirtyCells() == 0);
		
		cs = new ControlSystem("TEST_D.cft");
		cs.start();
		assertTrue((cs.getEmptyMeLight()) || cs.countPotentiallyDirtyCells() == 0);
		
		cs = new ControlSystem("TEST_E.cft");
		cs.start();
		assertTrue((cs.getEmptyMeLight()) || cs.countPotentiallyDirtyCells() == 0);
	}
}
