package edu.cleansweep.simulator.floor;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.cleansweep.simulator.floor.*;

public class BareFloorStateTest {

	@Test
	public void testBareFloorState(){
		//Setup
		FloorSimulator ds = new FloorSimulator();
		BareFloorState hds = new BareFloorState(ds);
		
		assertNotNull(hds);
	}
	
	@Test
	public void switchHighPileTest()
	{
		FloorSimulator ds = new FloorSimulator();
		BareFloorState bds = new BareFloorState(ds);
		HighPileState hds = new HighPileState(ds);
		LowPileState lds = new LowPileState(ds);
		ds.setCurrentState(bds);
        ds.getCurrentState().SwitchHighPile();
		assertEquals(ds.getCurrentState(), ds.getHighPileState());

		ds.getCurrentState().printState();
		
	}

	@Test
	public void switchLowPileTest()
	{
		FloorSimulator ds = new FloorSimulator();
		BareFloorState bds = new BareFloorState(ds);
		LowPileState lds = new LowPileState(ds);
		ds.setCurrentState(bds);
        ds.getCurrentState().SwitchLowPile();
		assertEquals(ds.getCurrentState(), ds.getLowPileState());
		ds.getCurrentState().printState();
		
	}

	@Test
	public void switchbareFloorPileTest()
	{
		FloorSimulator ds = new FloorSimulator();
		LowPileState lds = new LowPileState(ds);
		ds.setCurrentState(lds);
        ds.getCurrentState().SwitchBareFloor();
		assertEquals(ds.getCurrentState(), ds.getBareFloorState());

		ds.getCurrentState().printState();
		
		
	}
	
}
