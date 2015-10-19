package edu.cleansweep.simulator.dirt;

import static org.junit.Assert.*;

import org.junit.Test;



public class DirtSimulatorTest {
	
	@Test
	public void testDirtSimulator() {
		//Setup
		DirtSimulator ds = new DirtSimulator();
		HasNoDirtState hds = new HasNoDirtState(ds);
		
		assertNotNull(hds);
	}
	
	@Test
	public void testGetDirtyState() {

		DirtSimulator ds = new DirtSimulator();
		
		assertEquals(ds.getCurrentState(), ds.getDirtyState());
        ds.getCurrentState().switchClean();        
		assertEquals(ds.getCurrentState(), ds.getCleanState());
        ds.getCurrentState().switchDirty();
		assertEquals(ds.getCurrentState(), ds.getDirtyState());
		ds.getCurrentState().printState();
	}

	@Test
	public void testSetDirtyState() {
	
		DirtSimulator ds = new DirtSimulator();
		HasDirtState hds = new HasDirtState(ds);	
        ds.setDirtyState(hds);
		ds.setCurrentState(hds);
		
		assertEquals(ds.getCurrentState(), ds.getDirtyState());
		ds.getCurrentState().printState();
	}


	@Test
	public void testSetCleanState() {

		DirtSimulator ds = new DirtSimulator();
		HasNoDirtState hds = new HasNoDirtState(ds);	
        ds.setCleanState(hds);
		ds.setCurrentState(hds);
		
		assertEquals(ds.getCurrentState(), ds.getCleanState());
		
		ds.getCurrentState().printState();
	}

}
