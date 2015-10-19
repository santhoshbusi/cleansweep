package edu.cleansweep.simulator.dirt;

import static org.junit.Assert.*;
import org.junit.Test;

public class HasDirtStateTest {

	@Test
	public void constructorTest(){
		//Setup
		DirtSimulator ds = new DirtSimulator();
		HasDirtState hds = new HasDirtState(ds);
		
		assertNotNull(hds);
	}
	
	@Test
	public void switchCleanTest()
	{
		DirtSimulator ds = new DirtSimulator();
		
		//Initial Value is dirty (Has Dirt State is the class we're trying to test)
		assertEquals(ds.getCurrentState(), ds.getDirtyState());
		
		//Switch To Clean (the switch actually occurs on Has Dirt State Class)
		ds.getCurrentState().switchClean();
		assertEquals(ds.getCurrentState(), ds.getCleanState());
		
		//Rest To Dirty
		ds.setCurrentState(ds.getDirtyState());
		ds.getCurrentState().printState();
		//Test 
	}
	
	@Test
	public void switchDirtyTest()
	{
		DirtSimulator ds = new DirtSimulator();
		
		//Initial Value is dirty
		assertEquals(ds.getCurrentState(), ds.getDirtyState());
		
		//Switch To Dirty
		ds.getCurrentState().switchDirty();
		assertEquals(ds.getCurrentState(), ds.getDirtyState());
		ds.setCurrentState(ds.getCurrentState());
		ds.getCurrentState().printState();
	}
}
